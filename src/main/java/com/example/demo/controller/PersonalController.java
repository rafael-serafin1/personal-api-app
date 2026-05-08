package com.example.demo.controller;

import java.util.*;
import com.example.demo.repository.*;
import com.example.demo.model.Aluno;
import com.example.demo.model.Personal;
import org.springframework.http.HttpStatus;
import com.example.demo.dto.PersonalRequest;
import com.example.demo.service.PersonalService;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/personais")
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

    @GetMapping("/{id}")
    public Personal getPersonal(@PathVariable Integer id) {
        return repo.findById(id).orElse(null);
    }
    

    /// Listar alunos de um personal. Não coloque "/personal/" antes de {id} porque já tem no @RequestMapping
    @GetMapping("/{id}/alunos")
    public List<Aluno> listarAlunos(@PathVariable Integer id) {
        return alunos.findByIdPersonal(id);
    }
    

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Personal salvar(@RequestBody PersonalRequest request) {
        return service.criarPersonal(request);
    }

    @PutMapping("/{id}")
    public Personal atualizar(@PathVariable Integer id, @RequestBody PersonalRequest request) {
        return service.atualizarPersonal(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Integer id) {
        repo.deleteById(id);
    }
}