package com.example.demo.dto.mapper;

import com.example.demo.dto.NotaDTO;
import com.example.demo.entity.NotaEntity;

public class NotaDtoMapper {

    public static NotaDTO converteNotaEntity(NotaEntity notaEntity) {
        NotaDTO notaDTO = new NotaDTO();
        notaDTO.setMateria(MateriaDtoMapper.converteMateriaEntity(notaEntity.getMateria()));
        notaDTO.setMentoria(MentoriaDtoMapper.converteMentoriaEntity(notaEntity.getMentoria()));
        notaDTO.setData(notaEntity.getData());
        notaDTO.setNota(notaEntity.getNota());
        return notaDTO;
    }
}
