package com.example.demo.service;

import com.example.demo.model.Treino;
import com.example.demo.dto.TreinoRequest;
import org.springframework.stereotype.Service;
import com.example.demo.repository.TreinoRepository;

@Service
public class TreinoService {
    private final TreinoRepository repository;

    public TreinoService(TreinoRepository repository) {
        this.repository = repository;
    }

    public Treino criarTreino(TreinoRequest request) {
        Treino treino = new Treino();

        treino.setIdAluno(request.getIdAluno());
        treino.setNome(request.getNome());
        treino.setData(request.getDataCriacao());
        treino.setObs(request.getObservacoes());

        return repository.save(treino);
    }
}