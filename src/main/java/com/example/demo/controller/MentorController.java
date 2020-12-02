package com.example.demo.controller;

import com.example.demo.dto.MentorDTO;
import com.example.demo.service.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/mentores")
@Api(value = "Mentores", description = "CRUD Mentor")
public class MentorController {

    @Autowired
    private MentorService mentorService;

    @ApiOperation(value = "Pegar todos os mentores")
    @GetMapping
    public ResponseEntity<Iterable<MentorDTO>> getMentores() {
        return new ResponseEntity(mentorService.getMentores(), HttpStatus.ACCEPTED);
    }

    @ApiOperation(value = "Pegar o mentor por id")
    @GetMapping("/{id}")
    public ResponseEntity<MentorDTO> getMentor(@PathVariable Long id) {
        MentorDTO mentor = mentorService.getMentorByIndex(id);
        return ResponseEntity.ok(mentor);
    }

    @ApiOperation(value = "Criar mentor")
    @PostMapping
    public ResponseEntity postMentor(@RequestBody MentorDTO mentorDTO) {
        mentorService.criaMentor(mentorDTO);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "Deletar mentor por id")
    @DeleteMapping("/{id}")
    public ResponseEntity deleteMentor(@PathVariable Long id) {
        mentorService.excluiMentor(id);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "Alterar mentor por id")
    @PutMapping("/{id}")
    public ResponseEntity putMentor(@RequestBody MentorDTO mentorDTO,
                                    @PathVariable Long id) {
        if (mentorService.alteraMentor(mentorDTO, id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
