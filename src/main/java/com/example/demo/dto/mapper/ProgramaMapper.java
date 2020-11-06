package com.example.demo.dto.mapper;

import com.example.demo.dto.ProgramaDTO;
import com.example.demo.entity.ProgramaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProgramaMapper {
    ProgramaEntity toProgramaDto(ProgramaDTO programaDTO);

    ProgramaDTO toProgramaEntity(ProgramaEntity programaEntity);
}
