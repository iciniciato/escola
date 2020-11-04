package com.example.demo.dto.mapper;

import com.example.demo.dto.MentorDTO;
import com.example.demo.entity.MentorEntity;

import java.util.Objects;

public class MentorEntityMapper {

    public static MentorEntity converteMentorDto(MentorDTO mentorDTO) {
        MentorEntity mentorEntity = new MentorEntity();
        mentorEntity.setNome(mentorDTO.getNome());
        mentorEntity.setPais(mentorDTO.getPais());
        return mentorEntity;
    }

    public static MentorEntity setaInformacoesMentor(MentorDTO mentorDTO, MentorEntity mentorEntity) {
        if (Objects.nonNull(mentorDTO.getNome())) {
            mentorEntity.setNome(mentorDTO.getNome());
        }
        if (Objects.nonNull(mentorDTO.getPais())) {
            mentorEntity.setPais(mentorDTO.getPais());
        }
        return mentorEntity;
    }
}
