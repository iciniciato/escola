package com.example.demo.dto.mapper;

import com.example.demo.dto.ProgramaDTO;
import com.example.demo.entity.ProgramaEntity;

public class ProgramaEntityMapper {

    public static ProgramaEntity converterProgramaDto(ProgramaDTO programaDTO) {
        ProgramaEntity programaEntity = new ProgramaEntity();
        programaEntity.setNome(programaDTO.getNome());
        programaEntity.setAno(programaDTO.getAno());
        programaEntity.setDataInicio(programaDTO.getDataInicio());
        programaEntity.setDataFim(programaDTO.getDataFim());
        return programaEntity;
    }

    public static ProgramaEntity setaInformacoesPrograma(ProgramaDTO programaDTO, ProgramaEntity programaEntity) {
        programaEntity.setNome(programaDTO.getNome());
        programaEntity.setAno(programaDTO.getAno());
        programaEntity.setDataInicio(programaDTO.getDataInicio());
        programaEntity.setDataFim(programaDTO.getDataFim());
        return programaEntity;
    }
}
