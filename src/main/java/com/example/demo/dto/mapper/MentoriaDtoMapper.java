package com.example.demo.dto.mapper;

import com.example.demo.dto.MentoriaDTO;
import com.example.demo.entity.MentoriaEntity;

public class MentoriaDtoMapper {

    public static MentoriaDTO converteMentoriaEntity(MentoriaEntity mentoriaEntity) {
        MentoriaDTO mentoriaDTO = new MentoriaDTO();
        mentoriaDTO.setAluno(AlunoDtoMapper.converteAlunoEntity(mentoriaEntity.getAluno()));
        mentoriaDTO.setMentor(MentorDtoMapper.converteMentorEntity(mentoriaEntity.getMentor()));
        return mentoriaDTO;
    }
}
