package com.example.demo.service;

import com.example.demo.model.Personal;
import com.example.demo.dto.PersonalRequest;
import org.springframework.stereotype.Service;
import com.example.demo.repository.PersonalRepository;

@Service
public class PersonalService {
    private final PersonalRepository repository;

    public PersonalService(PersonalRepository repository) {
        this.repository = repository;
    }

    public Personal criarPersonal(PersonalRequest request) {
        Personal personal = new Personal();

        personal.setNome(request.getNome());
        personal.setEmail(request.getEmail());
        personal.setTelefone(request.getTelefone());
        personal.setRegistroProf(request.getRegistroProf());

        return repository.save(personal);
    }
}