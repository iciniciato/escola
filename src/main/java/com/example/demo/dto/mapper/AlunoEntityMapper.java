package com.example.demo.dto.mapper;

import com.example.demo.dto.AlunoDTO;
import com.example.demo.entity.AlunoEntity;

public class AlunoEntityMapper {

    public static AlunoEntity converteAlunoDto(AlunoDTO alunoDTO) {
        AlunoEntity alunoEntity = new AlunoEntity();
        alunoEntity.setNome(alunoDTO.getNome());
        alunoEntity.setClasse(alunoDTO.getClasse());
        return alunoEntity;
    }

    public static AlunoEntity setaInformacoesAluno(AlunoDTO alunoDTO, AlunoEntity alunoEntity) {
        alunoEntity.setNome(alunoDTO.getNome());
        alunoEntity.setClasse(alunoDTO.getClasse());
        return alunoEntity;
    }
}






















