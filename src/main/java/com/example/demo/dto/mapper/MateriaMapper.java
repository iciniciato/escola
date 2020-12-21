package com.example.demo.dto.mapper;

import com.example.demo.dto.MateriaDTO;
import com.example.demo.entity.MateriaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MateriaMapper {
    MateriaDTO toMateriaDTO(MateriaEntity materiaEntity);

    MateriaEntity toMateriaEntity(MateriaDTO materiaDTO);
}
