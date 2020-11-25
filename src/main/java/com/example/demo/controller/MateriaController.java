package com.example.demo.controller;

import com.example.demo.dto.MateriaDTO;
import com.example.demo.service.MateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/materias")
public class MateriaController {

    @Autowired
    private MateriaService materiaService;

    @GetMapping
    public ResponseEntity<Iterable<MateriaDTO>> getAlunos() {
        return new ResponseEntity(materiaService.getMaterias(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MateriaDTO> getMateria(@PathVariable Long id) {
        MateriaDTO materiaDTO = materiaService.getMateriaByIndex(id);
        return ResponseEntity.ok(materiaDTO);
    }

    @PostMapping
    public ResponseEntity postMateria(@RequestBody MateriaDTO materiaDTO) {
        materiaService.criaMateria(materiaDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteMateria(@PathVariable Long id) {
        materiaService.excluiMateria(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity putMateria(@RequestBody MateriaDTO materiaDTO,
                                     @PathVariable Long id) {
        if (materiaService.alteraMateria(materiaDTO, id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
