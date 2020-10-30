package com.example.demo.dto.mapper;

import com.example.demo.dto.MentorDTO;
import com.example.demo.entity.MentorEntity;

public class MentorDtoMapper {

    public static MentorDTO converteMentorEntity(MentorEntity mentorEntity) {
        MentorDTO mentorDTO = new MentorDTO();
        mentorDTO.setNome(mentorEntity.getNome());
        mentorDTO.setPais(mentorEntity.getPais());
        return mentorDTO;
    }
}
