package com.example.demo.service;

import com.example.demo.dto.NotaDTO;
import com.example.demo.dto.VinculaNotaDTO;
import com.example.demo.dto.mapper.NotaDtoMapper;
import com.example.demo.entity.MateriaEntity;
import com.example.demo.entity.MentoriaEntity;
import com.example.demo.entity.NotaEntity;
import com.example.demo.repository.MateriaRepository;
import com.example.demo.repository.MentoriaRepository;
import com.example.demo.repository.NotaRepository;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class NotaService {

    @Autowired
    private NotaRepository notaRepository;

    @Autowired
    private MentoriaRepository mentoriaRepository;

    @Autowired
    private MateriaRepository materiaRepository;

    public Iterable<NotaEntity> getNotas() {
        Iterable<NotaEntity> notas = notaRepository.findAll();
        return notas;
    }

    public NotaDTO getNotaByIndex(Long id) {
        Optional<NotaEntity> notaEntity = notaRepository.findById(id);
        NotaDTO notaDTO = new NotaDTO();
        if (notaEntity.isPresent()) {
            notaDTO = NotaDtoMapper.converteNotaEntity(notaEntity.get());
        }
        return notaDTO;
    }

    public void vinculaNota(VinculaNotaDTO vinculaNotaDTO) {
        NotaEntity notaEntity = new NotaEntity();
        Optional<MentoriaEntity> mentoriaEntity = mentoriaRepository.findById(vinculaNotaDTO.getIdMentoria());
        Optional<MateriaEntity> materiaEntity = materiaRepository.findById(vinculaNotaDTO.getIdMateria());
        if (mentoriaEntity.isPresent() && materiaEntity.isPresent()) {
            notaEntity.setMentoria(mentoriaEntity.get());
            notaEntity.setMateria(materiaEntity.get());
            notaEntity.setData(vinculaNotaDTO.getData());
            notaEntity.setNota(vinculaNotaDTO.getNota());
            notaRepository.save(notaEntity);
        }
    }

    public void excluiNota(Long id) {
        NotaEntity notaEntity = new NotaEntity();
        notaEntity.setId(id);
        notaRepository.delete(notaEntity);
    }

    public Boolean alteraNota(VinculaNotaDTO vinculaNotaDTO, Long id) {
        Optional<NotaEntity> notaParaAlterar = notaRepository.findById(id);
        if (Objects.nonNull(vinculaNotaDTO.getIdMentoria())) {
            Optional<MentoriaEntity> mentoriaEntity = mentoriaRepository.findById(vinculaNotaDTO.getIdMentoria());
            notaParaAlterar.get().setMentoria(mentoriaEntity.get());
        }
        if (Objects.nonNull(vinculaNotaDTO.getIdMateria())) {
            Optional<MateriaEntity> materiaEntity = materiaRepository.findById(vinculaNotaDTO.getIdMateria());
            notaParaAlterar.get().setMateria(materiaEntity.get());
        }
        if (Objects.nonNull(vinculaNotaDTO.getData())) {
            notaParaAlterar.get().setData(vinculaNotaDTO.getData());
        }
        if (Objects.nonNull(vinculaNotaDTO.getNota())) {
            notaParaAlterar.get().setNota(vinculaNotaDTO.getNota());
        }
        notaRepository.save(notaParaAlterar.get());
        return true;
    }
}
