package com.example.demo.controller;

import java.util.*;
import com.example.demo.repository.*;
import com.example.demo.model.Treino;
import com.example.demo.dto.TreinoRequest;
import com.example.demo.service.TreinoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestController
@RequestMapping("/treino")
public class TreinoController {
    private final TreinoRepository repo;
    private final TreinoService service;

    public TreinoController(TreinoRepository repo, TreinoService service) {
        this.repo = repo;
        this.service = service;
    }

    @GetMapping
    public List<Treino> listar() {
        return repo.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Treino salvar(@RequestBody TreinoRequest request) {
        return service.criarTreino(request);
    }
}
