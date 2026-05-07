package com.example.demo.controller;

import java.util.*;
import com.example.demo.repository.*;
import com.example.demo.model.Exercicio;
import com.example.demo.dto.ExercicioRequest;
import com.example.demo.service.ExercicioService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseStatus;

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

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Exercicio salvar(@RequestBody ExercicioRequest request) {
        return service.criarExercicio(request);
    }
}