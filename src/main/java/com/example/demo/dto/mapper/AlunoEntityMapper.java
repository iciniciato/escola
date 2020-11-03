package com.example.demo.dto.mapper;

import com.example.demo.dto.AlunoDTO;
import com.example.demo.entity.AlunoEntity;

import java.util.Objects;

public class AlunoEntityMapper {

    public static AlunoEntity converteAlunoDto(AlunoDTO alunoDTO) {
        AlunoEntity alunoEntity = new AlunoEntity();
        alunoEntity.setNome(alunoDTO.getNome());
        alunoEntity.setClasse(alunoDTO.getClasse());
        return alunoEntity;
    }

    public static AlunoEntity setaInformacoesAluno(AlunoDTO alunoDTO, AlunoEntity alunoEntity) {
        if (Objects.nonNull(alunoDTO.getNome())) {
            alunoEntity.setNome(alunoDTO.getNome());
        }
        if (Objects.nonNull(alunoDTO.getClasse())) {
            alunoEntity.setClasse(alunoDTO.getClasse());
        }
        return alunoEntity;
    }
}






















