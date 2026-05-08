package com.example.demo.service;

import java.sql.Date;
import java.util.Map;
import com.example.demo.model.Aluno;
import com.example.demo.dto.AlunoRequest;
import org.springframework.stereotype.Service;
import com.example.demo.repository.AlunoRepository;

@Service
public class AlunoService {
    private final AlunoRepository repository;

    public AlunoService(AlunoRepository repository) {
        this.repository = repository;
    }

    public Aluno criarAluno(AlunoRequest request) {
        Aluno aluno = new Aluno();

        aluno.setIdPersonal(request.getIdPersonal());
        aluno.setNome(request.getNome());
        aluno.setData(request.getDataNascimento());
        aluno.setPeso(request.getPeso());
        aluno.setAltura(request.getAltura());
        aluno.setObjetivo(request.getObjetivo());

        return repository.save(aluno);
    }

    public Aluno atualizarAluno(Integer id, AlunoRequest request) {
        return repository.findById(id).map(aluno -> {
            aluno.setIdPersonal(request.getIdPersonal());
            aluno.setNome(request.getNome());
            aluno.setData(request.getDataNascimento());
            aluno.setPeso(request.getPeso());
            aluno.setAltura(request.getAltura());
            aluno.setObjetivo(request.getObjetivo());

            return repository.save(aluno);
        }).orElse(null);
    }

    public void deletarAluno(Integer id) {
        repository.deleteById(id);
    }

    public Aluno atualizarParcialmenteAluno(Integer id, Map<String, Object> updates) {
        return repository.findById(id).map(aluno -> {
            if (updates.containsKey("idPersonal")) aluno.setIdPersonal((Integer) updates.get("idPersonal"));
            if (updates.containsKey("nome")) aluno.setNome((String) updates.get("nome"));
            if (updates.containsKey("dataNascimento")) aluno.setData((Date) updates.get("dataNascimento"));
            if (updates.containsKey("peso")) aluno.setPeso((Double) updates.get("peso"));
            if (updates.containsKey("altura")) aluno.setAltura((Double) updates.get("altura"));
            if (updates.containsKey("objetivo")) aluno.setObjetivo((String) updates.get("objetivo"));

            return repository.save(aluno);
        }).orElse(null);
    }
}
