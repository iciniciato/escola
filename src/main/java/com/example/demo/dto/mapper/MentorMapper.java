package com.example.demo.dto.mapper;

import com.example.demo.dto.MentorDTO;
import com.example.demo.entity.MentorEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MentorMapper {
    MentorEntity toMentorDto(MentorDTO mentorDTO);

    MentorDTO toMentorEntity(MentorEntity mentorEntity);
}