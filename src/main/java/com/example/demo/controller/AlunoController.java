package com.example.demo.controller;

import com.example.demo.dto.AlunoDTO;
import com.example.demo.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.net.URI;

@RestController
@RequestMapping("/alunos")
@Api(value = "Alunos", description = "CRUD Aluno")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @ApiOperation(value = "Pegar todos os alunos")
    @GetMapping
    public ResponseEntity<Iterable<AlunoDTO>> getAlunos() {
        return new ResponseEntity(alunoService.getAlunos(), HttpStatus.ACCEPTED);
    }

    @ApiOperation(value = "Pegar o aluno por id")
    @GetMapping("/{id}")
    public ResponseEntity<AlunoDTO> getAluno(@PathVariable Long id) {
        AlunoDTO alunoDTO = alunoService.getAlunoByIndex(id);
        return ResponseEntity.ok(alunoDTO);
    }

    @ApiOperation(value = "Criar aluno")
    @PostMapping
    public ResponseEntity postAluno(@RequestBody AlunoDTO alunodto) {
        alunoService.criaAluno(alunodto);
        return ResponseEntity.created(URI.create("/aluno/" + alunodto.getId())).build();
    }

    @ApiOperation(value = "Deletar aluno por id")
    @DeleteMapping("/{id}")
    public ResponseEntity deleteAluno(@PathVariable Long id) {
        alunoService.excluiAluno(id);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "Alterar aluno por id")
    @PutMapping("/{id}")
    public ResponseEntity putAluno(@RequestBody AlunoDTO alunodto,
                                   @PathVariable Long id) {
        if (alunoService.alteraAluno(alunodto, id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
