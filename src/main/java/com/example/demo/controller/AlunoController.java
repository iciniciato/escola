package com.example.demo.controller;

import com.example.demo.dto.AlunoDTO;
import com.example.demo.exceptions.ImpossivelExcluir;
import com.example.demo.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public ResponseEntity<Iterable<AlunoDTO>> getAlunos() {
        return new ResponseEntity(alunoService.getAlunos(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoDTO> getAluno(@PathVariable Long id) {
        AlunoDTO alunoDTO = alunoService.getAlunoByIndex(id);
        return ResponseEntity.ok(alunoDTO);
    }

    @PostMapping
    public ResponseEntity postAluno(@RequestBody AlunoDTO alunodto) {
        alunoService.criaAluno(alunodto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteAluno(@PathVariable Long id) {
        alunoService.excluiAluno(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity putAluno(@RequestBody AlunoDTO alunodto,
                                   @PathVariable Long id) {
        if (alunoService.alteraAluno(alunodto, id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
