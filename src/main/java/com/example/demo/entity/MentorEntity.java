package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "MENTOR")
public class MentorEntity {

    private String nome;
    private String pais;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
