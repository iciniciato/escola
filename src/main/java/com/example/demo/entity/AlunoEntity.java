package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "ALUNO")
public class AlunoEntity {

    private String nome;
    private String classe;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
