package com.example.demo.dto.mapper;

import com.example.demo.dto.AlunoDTO;
import com.example.demo.entity.AlunoEntity;

public class AlunoDtoMapper {

    public static AlunoDTO converteAlunoEntity(AlunoEntity alunoEntity) {
        AlunoDTO alunoDTO = new AlunoDTO();
        alunoDTO.setNome(alunoEntity.getNome());
        alunoDTO.setClasse(alunoEntity.getClasse());
        return alunoDTO;
    }
}
