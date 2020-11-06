package com.example.demo.dto.mapper;

import com.example.demo.dto.MateriaDTO;
import com.example.demo.entity.MateriaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MateriaMapper {
    MateriaDTO toMateriaEntity(MateriaEntity materiaEntity);

    MateriaEntity toMateriaDto(MateriaDTO materiaDTO);
}
