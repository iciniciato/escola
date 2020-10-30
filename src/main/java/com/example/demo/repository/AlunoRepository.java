package com.example.demo.repository;

import com.example.demo.entity.AlunoEntity;
import org.springframework.data.repository.CrudRepository;

public interface AlunoRepository extends CrudRepository<AlunoEntity, Long> {
}
