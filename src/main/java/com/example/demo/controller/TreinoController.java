package com.example.demo.controller;

import java.util.*;
import com.example.demo.repository.*;
import com.example.demo.model.Treino;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/treino")
public class TreinoController {
    private final TreinoRepository repo;

    public TreinoController(TreinoRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Treino> listar() {
        return repo.findAll();
    }

    @PostMapping
    public Treino salvar(@RequestBody Treino user) {
        return repo.save(user);
    }
}
