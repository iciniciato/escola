package com.example.demo.repository;

import com.example.demo.entity.MentorEntity;
import org.springframework.data.repository.CrudRepository;

public interface MentorRepository extends CrudRepository<MentorEntity, Long> {
}
