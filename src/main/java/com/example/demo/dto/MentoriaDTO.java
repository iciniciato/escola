package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MentoriaDTO {

    private Long id;
    private AlunoDTO aluno;
    private MentorDTO mentor;
}
