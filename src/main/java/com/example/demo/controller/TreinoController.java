package com.example.demo.controller;

import java.util.*;
import com.example.demo.repository.*;
import com.example.demo.model.Treino;
import com.example.demo.model.Exercicio;
import com.example.demo.model.Personal;
import com.example.demo.dto.TreinoRequest;
import org.springframework.http.HttpStatus;
import com.example.demo.service.TreinoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestController
@RequestMapping("/treinos")
public class TreinoController {
    private final TreinoRepository repo;
    private final TreinoService service;
    private final ExercicioRepository exercicio;

    public TreinoController(TreinoRepository repo, TreinoService service, ExercicioRepository exercicio) {
        this.repo = repo;
        this.service = service;
        this.exercicio = exercicio;
    }

    @GetMapping
    public List<Treino> listar() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Treino getTreino(@PathVariable Integer id) {
        return repo.findById(id).orElse(null);
    }

    @GetMapping("/{id}/exercicios")
    public List<Exercicio> listarExercicios(@PathVariable Integer id) {
        return exercicio.findByIdTreino(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Treino salvar(@RequestBody TreinoRequest request) {
        return service.criarTreino(request);
    }
}
