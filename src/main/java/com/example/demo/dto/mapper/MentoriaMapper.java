package com.example.demo.dto.mapper;

import com.example.demo.dto.MentoriaDTO;
import com.example.demo.entity.MentoriaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MentoriaMapper {
   MentoriaDTO toMentoriaEntity(MentoriaEntity mentoriaEntity);
}
