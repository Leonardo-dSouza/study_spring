package com.tribosfighting.app.controller;

import com.tribosfighting.app.entity.Trabalho;
import com.tribosfighting.app.service.TrabalhoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/trabalho")
public class TrabalhoController {

    private final TrabalhoService service;

    public TrabalhoController(TrabalhoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Trabalho> listarTodos(){
        return service.listarTodos();
    }

    @PostMapping
    public ResponseEntity<Trabalho> cadastrar(@RequestBody Trabalho trabalho) {
        Trabalho salvo = service.cadastrar(trabalho);
        return ResponseEntity.created(URI.create("/trabalho")).body(salvo);
    }

    @GetMapping("/buscar")
    public List<Trabalho> buscar(@RequestParam("titulo") String titulo,
                                 @RequestParam("ra") Long ra) {
        return service.buscarPorRaETitulo(ra, titulo);
    }






}
