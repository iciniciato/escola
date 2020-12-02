package com.example.demo.controller;

import com.example.demo.dto.MentoriaDTO;
import com.example.demo.dto.VinculaMentoriaDTO;
import com.example.demo.service.MentoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/mentorias")
@Api(value = "Mentorias", description = "CRUD Mentoria")
public class MentoriaController {

    @Autowired
    private MentoriaService mentoriaService;

    @ApiOperation(value = "Pegar todos as mentorias")
    @GetMapping
    public ResponseEntity<Iterable<MentoriaDTO>> getMentorias() {
        return new ResponseEntity(mentoriaService.getMentorias(), HttpStatus.ACCEPTED);
    }

    @ApiOperation(value = "Pegar a mentoria por id")
    @GetMapping("/{id}")
    public ResponseEntity<MentoriaDTO> getMentoria(@PathVariable Long id) {
        MentoriaDTO mentoriaDTO = mentoriaService.getMentoriaByIndex(id);
        return ResponseEntity.ok(mentoriaDTO);
    }

    @ApiOperation(value = "Vincular mentoria")
    @PostMapping
    public ResponseEntity postMentoria(@RequestBody VinculaMentoriaDTO vinculaMentoriaDTO) {
        mentoriaService.vinculaMentoria(vinculaMentoriaDTO);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "Deletar mentoria por id")
    @DeleteMapping("/{id}")
    public ResponseEntity deleteMentoria(@PathVariable Long id) {
        mentoriaService.excluiMentoria(id);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "Alterar mentoria por id")
    @PutMapping("/{id}")
    public ResponseEntity putMentoria(@RequestBody VinculaMentoriaDTO vinculaMentoriaDTO,
                                      @PathVariable Long id) {
        if (mentoriaService.alteraMentoria(vinculaMentoriaDTO, id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
