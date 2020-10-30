package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class ProgramaDTO {

    private String nome;

    @DateTimeFormat(pattern = "YYYY-MM-dd")
    private LocalDate dataInicio;

    @DateTimeFormat(pattern = "YYYY-MM-dd")
    private LocalDate dataFim;

    private String ano;

}
