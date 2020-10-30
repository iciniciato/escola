package com.example.demo.dto.mapper;

import com.example.demo.dto.MateriaDTO;
import com.example.demo.entity.MateriaEntity;

public class MateriaDtoMapper {

    public static MateriaDTO converteMateriaEntity(MateriaEntity materiaEntity) {
        MateriaDTO materiaDTO = new MateriaDTO();
        materiaDTO.setNome(materiaEntity.getNome());
        return materiaDTO;
    }
}
