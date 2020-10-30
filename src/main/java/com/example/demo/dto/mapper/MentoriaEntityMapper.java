package com.example.demo.dto.mapper;

import com.example.demo.dto.MentoriaDTO;
import com.example.demo.entity.MentoriaEntity;

public class MentoriaEntityMapper {

    public static MentoriaEntity converteMentoria(MentoriaDTO mentoriaDTO) {
        MentoriaEntity mentoriaEntity = new MentoriaEntity();
        mentoriaEntity.setMentor(MentorEntityMapper.converterMentorDto(mentoriaDTO.getMentor()));
        mentoriaEntity.setAluno(AlunoEntityMapper.converteAlunoDto(mentoriaDTO.getAluno()));
        return mentoriaEntity;
    }
}
