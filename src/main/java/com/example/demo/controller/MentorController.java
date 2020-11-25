package com.example.demo.controller;

import com.example.demo.dto.MentorDTO;
import com.example.demo.service.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/mentores")
public class MentorController {

    @Autowired
    private MentorService mentorService;

    @GetMapping
    public ResponseEntity<Iterable<MentorDTO>> getMentores() {
        return new ResponseEntity(mentorService.getMentores(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MentorDTO> getMentor(@PathVariable Long id) {
        MentorDTO mentor = mentorService.getMentorByIndex(id);
        return ResponseEntity.ok(mentor);
    }

    @PostMapping
    public ResponseEntity postMentor(@RequestBody MentorDTO mentorDTO) {
        mentorService.criaMentor(mentorDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteMentor(@PathVariable Long id) {
        mentorService.excluiMentor(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity putMentor(@RequestBody MentorDTO mentorDTO,
                                    @PathVariable Long id) {
        if (mentorService.alteraMentor(mentorDTO, id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
