package com.example.demo.controller;

import com.example.demo.dto.NotaDTO;
import com.example.demo.dto.VinculaNotaDTO;
import com.example.demo.service.NotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/notas")
@Api(value = "Notas", description = "CRUD Nota")
public class NotaController {

    @Autowired
    private NotaService notaService;

    @ApiOperation(value = "Pegar todos as notas")
    @GetMapping
    public ResponseEntity<Iterable<NotaDTO>> getNotas() {
        return new ResponseEntity(notaService.getNotas(), HttpStatus.ACCEPTED);
    }

    @ApiOperation(value = "Pegar a nota por id")
    @GetMapping("/{id}")
    public ResponseEntity<NotaDTO> getNota(@PathVariable Long id) {
        NotaDTO notaDTO = notaService.getNotaByIndex(id);
        return ResponseEntity.ok(notaDTO);
    }

    @ApiOperation(value = "Vincular nota")
    @PostMapping
    public ResponseEntity postNota(@RequestBody VinculaNotaDTO vinculaNotaDTO) {
        notaService.vinculaNota(vinculaNotaDTO);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "Deletar nota por id")
    @DeleteMapping("/{id}")
    public ResponseEntity deleteNota(@PathVariable Long id) {
        notaService.excluiNota(id);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "Alterar nota por id")
    @PutMapping("/{id}")
    public ResponseEntity putNota(@RequestBody VinculaNotaDTO vinculaNotaDTO,
                                  @PathVariable Long id) {
        if (notaService.alteraNota(vinculaNotaDTO, id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
