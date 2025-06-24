package org.example.exo2apirest.controller;

import org.example.exo2apirest.dto.FilmReceiveDto;
import org.example.exo2apirest.dto.FilmResponseDto;
import org.example.exo2apirest.service.FilmService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/film")
public class FilmController {

    private FilmService service;

    public FilmController(FilmService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<FilmResponseDto>> getAll (){
        return ResponseEntity.ok(service.get());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FilmResponseDto> get (@PathVariable long id){
        return ResponseEntity.ok(service.get(id));
    }

    @PostMapping
    public ResponseEntity<FilmResponseDto> create (@RequestBody FilmReceiveDto filmReceiveDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(filmReceiveDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FilmResponseDto> update (@PathVariable long id , @RequestBody FilmReceiveDto filmReceiveDto){
        return ResponseEntity.ok(service.update(id,filmReceiveDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delte(@PathVariable long id){
        service.delete(id);
        return ResponseEntity.ok(String.format("film at id : %s is deleted",id));
    }

}
