package com.example.demo.dto.mapper;

import com.example.demo.dto.MateriaDTO;
import com.example.demo.entity.MateriaEntity;

public class MateriaEntityMapper {

    public static MateriaEntity converteMateriaDto(MateriaDTO materiaDTO) {
        MateriaEntity materiaEntity = new MateriaEntity();
        materiaEntity.setNome(materiaDTO.getNome());
        return materiaEntity;
    }

    public static MateriaEntity setaInformacoesMateria(MateriaDTO materiaDTO, MateriaEntity materiaEntity) {
        materiaEntity.setNome(materiaDTO.getNome());
        return materiaEntity;
    }
}
