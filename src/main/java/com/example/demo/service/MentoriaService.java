package com.example.demo.service;

import com.example.demo.dto.MentoriaDTO;
import com.example.demo.dto.VinculaMentoriaDTO;
import com.example.demo.dto.mapper.MentoriaDtoMapper;
import com.example.demo.entity.AlunoEntity;
import com.example.demo.entity.MentorEntity;
import com.example.demo.entity.MentoriaEntity;
import com.example.demo.repository.AlunoRepository;
import com.example.demo.repository.MentorRepository;
import com.example.demo.repository.MentoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MentoriaService {

    @Autowired
    private MentoriaRepository mentoriaRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private MentorRepository mentorRepository;

    public Iterable<MentoriaEntity> getMentorias() {
        Iterable<MentoriaEntity> mentorias = mentoriaRepository.findAll();
        return mentorias;
    }

    public MentoriaDTO getMentoriaByIndex(Long id) {
        Optional<MentoriaEntity> mentoriaEntity = mentoriaRepository.findById(id);
        MentoriaDTO mentoriaDTO = new MentoriaDTO();
        if (mentoriaEntity.isPresent()) {
            mentoriaDTO = MentoriaDtoMapper.converteMentoriaEntity(mentoriaEntity.get());
        }
        return mentoriaDTO;
    }

    public void vinculaMentoria(VinculaMentoriaDTO vinculaMentoriaDTO) {
        Optional<AlunoEntity> alunoEntity = alunoRepository.findById(vinculaMentoriaDTO.getIdAluno());
        Optional<MentorEntity> mentorEntity = mentorRepository.findById(vinculaMentoriaDTO.getIdMentor());
        if (alunoEntity.isPresent() && mentorEntity.isPresent()) {
            MentoriaEntity mentoriaEntity = new MentoriaEntity();
            mentoriaEntity.setAluno(alunoEntity.get());
            mentoriaEntity.setMentor(mentorEntity.get());
            mentoriaRepository.save(mentoriaEntity);
        }
    }

    public void excluiMentoria(Long id) {
        MentoriaEntity mentoriaEntity = new MentoriaEntity();
        mentoriaEntity.setId(id);
        mentoriaRepository.delete(mentoriaEntity);
    }

    public Boolean alteraMentoria(VinculaMentoriaDTO vinculaMentoriaDTO, Long id) {
        Optional<AlunoEntity> alunoEntity = alunoRepository.findById(vinculaMentoriaDTO.getIdAluno());
        Optional<MentorEntity> mentorEntity = mentorRepository.findById(vinculaMentoriaDTO.getIdMentor());
        Optional<MentoriaEntity> mentoriaParaAlterar = mentoriaRepository.findById(id);
        if (alunoEntity.isPresent() && mentorEntity.isPresent() && mentoriaParaAlterar.isPresent()) {
            mentoriaParaAlterar.get().setAluno(alunoEntity.get());
            mentoriaParaAlterar.get().setMentor(mentorEntity.get());
            mentoriaRepository.save(mentoriaParaAlterar.get());
            return true;
        }
        return false;
    }
}
