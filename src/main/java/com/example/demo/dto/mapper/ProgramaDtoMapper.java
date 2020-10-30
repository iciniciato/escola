package com.example.demo.dto.mapper;

import com.example.demo.dto.ProgramaDTO;
import com.example.demo.entity.ProgramaEntity;

public class ProgramaDtoMapper {

    public static ProgramaDTO converteProgramaEntity(ProgramaEntity programaEntity) {
        ProgramaDTO programaDTO = new ProgramaDTO();
        programaDTO.setNome(programaEntity.getNome());
        programaDTO.setAno(programaEntity.getAno());
        programaDTO.setDataInicio(programaEntity.getDataInicio());
        programaDTO.setDataFim(programaEntity.getDataFim());
        return programaDTO;
    }
}
