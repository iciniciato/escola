package com.example.demo.repository;

import com.example.demo.entity.MentoriaEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MentoriaRepository extends CrudRepository<MentoriaEntity, Long> {
    List<MentoriaEntity> findByAluno_Id(Long idAluno);
}
