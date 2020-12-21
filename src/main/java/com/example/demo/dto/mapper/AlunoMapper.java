package com.example.demo.dto.mapper;

import com.example.demo.dto.AlunoDTO;
import com.example.demo.entity.AlunoEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AlunoMapper {
    AlunoEntity toAlunoEntity(AlunoDTO alunoDTO);

    AlunoDTO toAlunoDTO(AlunoEntity alunoEntity);
}
