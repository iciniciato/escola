package com.example.demo.controller;

import com.example.demo.dto.ProgramaDTO;
import com.example.demo.service.ProgramaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/programa")
public class ProgramaController {

    @Autowired
    private ProgramaService programaService;

    @GetMapping
    public ResponseEntity<Iterable<ProgramaDTO>> getProgramas() {
        return new ResponseEntity(programaService.getProgramas(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProgramaDTO> getPrograma(@PathVariable Long id) {
        ProgramaDTO programa = programaService.getProgramaByIndex(id);
        return ResponseEntity.ok(programa);
    }

    @PostMapping
    public ResponseEntity postPrograma(@RequestBody ProgramaDTO programaDTO) {
        programaService.criaPrograma(programaDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePrograma(@PathVariable Long id) {
        programaService.excluiPrograma(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity putPrograma(@RequestBody ProgramaDTO programaDTO,
                                      @PathVariable Long id) {
        if (programaService.alteraPrograma(programaDTO, id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
