package com.example.demo.controller;

import java.util.*;

import com.example.demo.model.Aluno;
import com.example.demo.repository.*;
import com.example.demo.dto.AlunoRequest;
import org.springframework.http.HttpStatus;
import com.example.demo.service.AlunoService; 
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/aluno")
public class AlunoController {
    private final AlunoRepository repo;
    private final AlunoService service;

    public AlunoController(AlunoRepository repo, AlunoService service) {
        this.repo = repo;
        this.service = service;
    }

    @GetMapping
    public List<Aluno> listar() {
        return repo.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Aluno salvar(@RequestBody AlunoRequest user) {
        return service.criarAluno(user);
    }   
}
