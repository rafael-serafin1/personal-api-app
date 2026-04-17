package com.example.demo.controller;

import java.util.*;
import com.example.demo.repository.*;
import com.example.demo.model.Personal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/personal")
public class PersonalController {
    private final PersonalRepository repo;

    public PersonalController(PersonalRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Personal> listar() {
        return repo.findAll();
    }

    @PostMapping
    public Personal salvar(@RequestBody Personal user) {
        return repo.save(user);
    }
}
