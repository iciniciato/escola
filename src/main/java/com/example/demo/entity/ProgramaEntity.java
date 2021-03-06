package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "PROGRAMA")
public class ProgramaEntity {

    private String nome;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @DateTimeFormat(pattern = "YYYY-MM-dd")
    private LocalDate dataInicio;

    @DateTimeFormat(pattern = "YYYY-MM-dd")
    private LocalDate dataFim;

    private String ano;

}
