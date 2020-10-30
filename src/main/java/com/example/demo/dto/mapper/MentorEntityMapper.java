package com.example.demo.dto.mapper;

import com.example.demo.dto.MentorDTO;
import com.example.demo.entity.MentorEntity;

public class MentorEntityMapper {

    public static MentorEntity converterMentorDto(MentorDTO mentorDTO) {
        MentorEntity mentorEntity = new MentorEntity();
        mentorEntity.setNome(mentorDTO.getNome());
        mentorEntity.setPais(mentorDTO.getPais());
        return mentorEntity;
    }

    public static MentorEntity setaInformacoesMentor(MentorDTO mentorDTO, MentorEntity mentorEntity) {
        mentorEntity.setNome(mentorDTO.getNome());
        mentorEntity.setPais(mentorDTO.getPais());
        return mentorEntity;
    }
}
