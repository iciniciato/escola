package com.example.demo.controller;

import com.example.demo.dto.MateriaDTO;
import com.example.demo.service.MateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/materias")
@Api(value = "Matérias", description = "CRUD Matéria")
public class MateriaController {

    @Autowired
    private MateriaService materiaService;

    @ApiOperation(value = "Pegar todos as matérias")
    @GetMapping
    public ResponseEntity<Iterable<MateriaDTO>> getAlunos() {
        return new ResponseEntity(materiaService.getMaterias(), HttpStatus.ACCEPTED);
    }

    @ApiOperation(value = "Pegar matéria por id")
    @GetMapping("/{id}")
    public ResponseEntity<MateriaDTO> getMateria(@PathVariable Long id) {
        MateriaDTO materiaDTO = materiaService.getMateriaByIndex(id);
        return ResponseEntity.ok(materiaDTO);
    }

    @ApiOperation(value = "Criar matéria")
    @PostMapping
    public ResponseEntity postMateria(@RequestBody MateriaDTO materiaDTO) {
        materiaService.criaMateria(materiaDTO);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "Deletar matéria por id")
    @DeleteMapping("/{id}")
    public ResponseEntity deleteMateria(@PathVariable Long id) {
        materiaService.excluiMateria(id);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "Alterar matéria por id")
    @PutMapping("/{id}")
    public ResponseEntity putMateria(@RequestBody MateriaDTO materiaDTO,
                                     @PathVariable Long id) {
        if (materiaService.alteraMateria(materiaDTO, id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
