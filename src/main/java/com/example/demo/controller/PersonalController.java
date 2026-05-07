package com.example.demo.controller;

import java.util.*;
import com.example.demo.repository.*;
import com.example.demo.model.Aluno;
import com.example.demo.model.Personal;
import com.example.demo.dto.PersonalRequest;
import com.example.demo.service.PersonalService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestController
@RequestMapping("/personal")
public class PersonalController {
    private final PersonalRepository repo;
    private final AlunoRepository alunos;
    private final PersonalService service;

    public PersonalController(PersonalRepository repo, AlunoRepository alunos, PersonalService service) {
        this.repo = repo;
        this.alunos = alunos;
        this.service = service;
    }

    @GetMapping
    public List<Personal> listar() {
        return repo.findAll();
    }

    @GetMapping("/personal/{id}/alunos")
    public List<Aluno> listarAlunos(@PathVariable Integer id) {
        return alunos.findByIdPersonal(id);
    }
    

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Personal salvar(@RequestBody PersonalRequest request) {
        return service.criarPersonal(request);
    }
}