package com.example.demo.controller;

import java.util.*;
import com.example.demo.repository.*;
import com.example.demo.model.Exercicio;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exercicio")
public class ExercicioController {
    private final ExercicioRepository repo;

    public ExercicioController(ExercicioRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Exercicio> listar() {
        return repo.findAll();
    }

    @PostMapping
    public Exercicio salvar(@RequestBody Exercicio user) {
        return repo.save(user);
    }
}