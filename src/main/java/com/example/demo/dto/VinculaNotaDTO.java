package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VinculaNotaDTO {

    private Float nota;
    private Long idMateria;
    private Long idMentoria;

    @DateTimeFormat(pattern = "YYYY-MM-dd")
    private LocalDate data;
}
