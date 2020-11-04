package com.example.demo.dto.mapper;

import com.example.demo.dto.ProgramaDTO;
import com.example.demo.entity.ProgramaEntity;

import java.util.Objects;

public class ProgramaEntityMapper {

    public static ProgramaEntity converteProgramaDto(ProgramaDTO programaDTO) {
        ProgramaEntity programaEntity = new ProgramaEntity();
        programaEntity.setNome(programaDTO.getNome());
        programaEntity.setAno(programaDTO.getAno());
        programaEntity.setDataInicio(programaDTO.getDataInicio());
        programaEntity.setDataFim(programaDTO.getDataFim());
        return programaEntity;
    }

    public static ProgramaEntity setaInformacoesPrograma(ProgramaDTO programaDTO, ProgramaEntity programaEntity) {
        if (Objects.nonNull(programaDTO.getNome())) {
            programaEntity.setNome(programaDTO.getNome());
        }
        if (Objects.nonNull(programaDTO.getAno())) {
            programaEntity.setAno(programaDTO.getAno());
        }
        if (Objects.nonNull(programaDTO.getDataInicio())) {
            programaEntity.setDataInicio(programaDTO.getDataInicio());
        }
        if (Objects.nonNull(programaDTO.getDataFim())) {
            programaEntity.setDataFim(programaDTO.getDataFim());
        }
        return programaEntity;
    }
}
