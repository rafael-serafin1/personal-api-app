package com.example.demo.service;

import java.util.Map;
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

    public Personal atualizarPersonal(Integer id, PersonalRequest request) {
        Personal personal = repository.findById(id).orElse(null);
        if (personal == null) return null;
        
        personal.setNome(request.getNome());
        personal.setEmail(request.getEmail());
        personal.setTelefone(request.getTelefone());
        personal.setRegistroProf(request.getRegistroProf());
        return repository.save(personal);
    }

    public Personal atualizarParcialmente(Integer id, Map<String, Object> updates) {
        Personal personal = repository.findById(id).orElse(null);
        if (personal == null) return null;

        if (updates.containsKey("nome")) personal.setNome((String) updates.get("nome"));
        if (updates.containsKey("email")) personal.setEmail((String) updates.get("email"));
        if (updates.containsKey("telefone")) personal.setTelefone((String) updates.get("telefone"));
        if (updates.containsKey("registroProf")) personal.setRegistroProf((String) updates.get("registroProf"));

        return repository.save(personal);
    }
}