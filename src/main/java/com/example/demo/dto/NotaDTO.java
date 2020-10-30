package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotaDTO {

    private Float nota;

    @DateTimeFormat(pattern = "YYYY-MM-dd")
    private LocalDate data;

    private MateriaDTO materia;
    private MentoriaDTO mentoria;
}
