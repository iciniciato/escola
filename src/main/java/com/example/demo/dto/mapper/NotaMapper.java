package com.example.demo.dto.mapper;

import com.example.demo.dto.NotaDTO;
import com.example.demo.entity.NotaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NotaMapper {
    NotaDTO toNotaDTO(NotaEntity notaEntity);
}
