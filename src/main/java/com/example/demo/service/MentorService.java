package com.example.demo.service;

import com.example.demo.dto.MentorDTO;
import com.example.demo.entity.MentorEntity;
import com.example.demo.entity.MentoriaEntity;
import com.example.demo.exceptions.ImpossivelExcluir;
import com.example.demo.dto.mapper.MentorMapper;
import com.example.demo.repository.MentorRepository;
import com.example.demo.repository.MentoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class MentorService {

    @Autowired
    private MentorRepository mentorRepository;

    @Autowired
    private MentoriaRepository mentoriaRepository;

    @Autowired
    private MentorMapper mentorMapper;

    public Iterable<MentorEntity> getMentores() {
        Iterable<MentorEntity> mentores = mentorRepository.findAll();
        return mentores;
    }

    public MentorDTO getMentorByIndex(Long id) {
        Optional<MentorEntity> mentorEntity = mentorRepository.findById(id);
        MentorDTO mentorDTO = new MentorDTO();
        if (mentorEntity.isPresent()) {
            mentorDTO = mentorMapper.toMentorEntity(mentorEntity.get());
        }
        return mentorDTO;
    }

    public void criaMentor(MentorDTO mentorDTO) {
        MentorEntity mentorEntity = mentorMapper.toMentorDto(mentorDTO);
        mentorRepository.save(mentorEntity);
    }

    public void excluiMentor(Long id) {
        List<MentoriaEntity> mentoriaEntities = mentoriaRepository.findByMentor_Id(id);
        if (mentoriaEntities.isEmpty()) {
            Optional<MentorEntity> mentorEntity = mentorRepository.findById(id);
            if (mentorEntity.isPresent()) {
                mentorRepository.delete(mentorEntity.get());
            }
        } else {
            throw new ImpossivelExcluir("Impossível excluir mentor, pois está em uso na mentoria.");
        }
    }

    private MentorEntity setaInformacoesMentor(MentorDTO mentorDTO, MentorEntity mentorEntity) {
        if (Objects.nonNull(mentorDTO.getNome())) {
            mentorEntity.setNome(mentorDTO.getNome());
        }
        if (Objects.nonNull(mentorDTO.getPais())) {
            mentorEntity.setPais(mentorDTO.getPais());
        }
        return mentorEntity;
    }

    public Boolean alteraMentor(MentorDTO mentorDTO, Long id) {
        Optional<MentorEntity> mentorEntity = mentorRepository.findById(id);
        if (mentorEntity.isPresent()) {
            MentorEntity mentorParaAlterar = setaInformacoesMentor(mentorDTO, mentorEntity.get());
            mentorRepository.save(mentorParaAlterar);
            return true;
        }
        return false;
    }
}

