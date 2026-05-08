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


    /**
     * requisições GET para listar os alunos cadastrados
     * ? READ
     */
    @GetMapping
    public List<Aluno> listar() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Aluno getAluno(@PathVariable Integer id) {
        return repo.findById(id).orElse(null);
    }
    

    @GetMapping("/{id}/treinos")
    public List<Treino> getMethodName(@PathVariable Integer id) {
        return treino.findByIdAluno(id);
    }
    
    /**
     * requisições POST para criar um novo aluno
     * ? CREATE
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Aluno salvar(@RequestBody AlunoRequest user) {
        return service.criarAluno(user);
    } 

    /**
     * requisições PUT para atualizar um aluno existente
     * ? UPDATE
     */
    @PutMapping("/{id}")
    public Aluno atualizar(@PathVariable Integer id, @RequestBody AlunoRequest user) {
        return service.atualizarAluno(id, user);
    }

    /**
     * requisições DELETE para remover um aluno
     * ? DELETE
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Integer id) {
        service.deletarAluno(id);
    }


    /**
     * requisição extra: PATCH para atualizar parcialmente um aluno existente
     * ? UPDATE 2: the return
     */
    @PatchMapping("/{id}")
    public Aluno atualizarParcialmente(@PathVariable Integer id, @RequestBody Map<String, Object> updates) {
        return service.atualizarParcialmenteAluno(id, updates);
    }
}
