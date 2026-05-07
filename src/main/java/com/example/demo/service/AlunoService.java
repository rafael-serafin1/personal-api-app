package com.example.demo.service;

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
}
