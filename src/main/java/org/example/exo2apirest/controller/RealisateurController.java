package org.example.exo2apirest.controller;

import org.example.exo2apirest.dto.RealisateurReceiveDto;
import org.example.exo2apirest.dto.RealisateurResponseDto;
import org.example.exo2apirest.service.RealisateurService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/realisateur")
public class RealisateurController {

    private RealisateurService service;

    public RealisateurController(RealisateurService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<RealisateurResponseDto>> getAll (){
        return ResponseEntity.ok(service.get());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RealisateurResponseDto> get (@PathVariable long id){
        return ResponseEntity.ok(service.get(id));
    }

    @PostMapping
    public ResponseEntity<RealisateurResponseDto> create (@RequestBody RealisateurReceiveDto realisateurReceiveDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(realisateurReceiveDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RealisateurResponseDto> update (@PathVariable long id , @RequestBody RealisateurReceiveDto RealisateurReceiveDto){
        return ResponseEntity.ok(service.update(id,RealisateurReceiveDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delte(@PathVariable long id){
        service.delete(id);
        return ResponseEntity.ok(String.format("Realisateur at id : %s is deleted",id));
    }

}
