package com.example.demo.controller;

import java.util.*;

import com.example.demo.model.Aluno;
import com.example.demo.model.Treino;
import com.example.demo.repository.*;
import com.example.demo.dto.AlunoRequest;
import org.springframework.http.HttpStatus;
import com.example.demo.service.AlunoService; 
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/alunos")
public class AlunoController {
    private final AlunoRepository repo;
    private final AlunoService service;
    private final TreinoRepository treino;

    public AlunoController(AlunoRepository repo, AlunoService service, TreinoRepository treino) {
        this.repo = repo;
        this.service = service;
        this.treino = treino;
    }

    @GetMapping
    public List<Aluno> listar() {
        return repo.findAll();
    }

    @GetMapping("/{id}/treinos")
    public List<Treino> getMethodName(@PathVariable Integer id) {
        return treino.findByIdAluno(id);
    }
    

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Aluno salvar(@RequestBody AlunoRequest user) {
        return service.criarAluno(user);
    }   
}
