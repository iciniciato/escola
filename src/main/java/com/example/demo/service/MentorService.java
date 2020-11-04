package com.example.demo.service;

import com.example.demo.dto.MentorDTO;
import com.example.demo.dto.mapper.MentorDtoMapper;
import com.example.demo.dto.mapper.MentorEntityMapper;
import com.example.demo.entity.MentorEntity;
import com.example.demo.repository.MentorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MentorService {

    @Autowired
    private MentorRepository mentorRepository;

    public Iterable<MentorEntity> getMentores() {
        Iterable<MentorEntity> mentores = mentorRepository.findAll();
        return mentores;
    }

    public MentorDTO getMentorByIndex(Long id) {
        Optional<MentorEntity> mentorEntity = mentorRepository.findById(id);
        MentorDTO mentorDTO = new MentorDTO();
        if (mentorEntity.isPresent()) {
            mentorDTO = MentorDtoMapper.converteMentorEntity(mentorEntity.get());
        }
        return mentorDTO;
    }

    public void criaMentor(MentorDTO mentorDTO) {
        MentorEntity mentorEntity = MentorEntityMapper.converteMentorDto(mentorDTO);
        mentorRepository.save(mentorEntity);
    }

    public void excluiMentor(Long id) {
        MentorEntity mentorEntity = new MentorEntity();
        mentorEntity.setId(id);
        mentorRepository.delete(mentorEntity);
    }

    public Boolean alteraMentor(MentorDTO mentorDTO, Long id) {
        Optional<MentorEntity> mentorEntity = mentorRepository.findById(id);
        if (mentorEntity.isPresent()) {
            MentorEntity mentorParaAlterar =
                    MentorEntityMapper.setaInformacoesMentor(mentorDTO, mentorEntity.get());
            mentorRepository.save(mentorParaAlterar);
            return true;
        }
        return false;
    }
}

