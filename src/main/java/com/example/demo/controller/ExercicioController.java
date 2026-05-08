package com.example.demo.controller;

import java.util.*;
import com.example.demo.repository.*;
import com.example.demo.model.Exercicio;
import org.springframework.http.HttpStatus;
import com.example.demo.dto.ExercicioRequest;
import com.example.demo.service.ExercicioService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/exercicios")
public class ExercicioController {
    private final ExercicioRepository repo;
    private final ExercicioService service;

    public ExercicioController(ExercicioRepository repo, ExercicioService service) {
        this.repo = repo;
        this.service = service;
    }

    @GetMapping
    public List<Exercicio> listar() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Exercicio getExercicio(@PathVariable Integer id) {
        return repo.findById(id).orElse(null);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Exercicio salvar(@RequestBody ExercicioRequest request) {
        return service.criarExercicio(request);
    }

    @PutMapping("/{id}")
    public Exercicio atualizar(@PathVariable Integer id, @RequestBody ExercicioRequest request) {
        return service.atualizarExercicio(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Integer id) {
        repo.deleteById(id);
    }

    @PatchMapping("/{id}")
    public Exercicio atualizarParcial(@PathVariable Integer id, @RequestBody Map<String, Object> updates) {
        return service.atualizarParcialmente(id, updates);
    }
}