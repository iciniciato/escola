package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "NOTA")
public class NotaEntity {

    private Float nota;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @DateTimeFormat(pattern = "YYYY-MM-dd")
    private LocalDate data;

    @ManyToOne
    @JoinColumn(name = "materia_id")
    private MateriaEntity materia;

    @ManyToOne
    @JoinColumn(name = "mentoria_id")
    private MentoriaEntity mentoria;
}
