package com.example.demo.service;

import java.sql.Date;
import java.util.Map;
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

    public Treino atualizarTreino(Integer id, TreinoRequest request) {
        return repository.findById(id).map(treino -> {
            treino.setIdAluno(request.getIdAluno());
            treino.setNome(request.getNome());
            treino.setData(request.getDataCriacao());
            treino.setObs(request.getObservacoes());
            return repository.save(treino);
        }).orElse(null);   
    }

    public Treino atualizarParcialmente(Integer id, Map<String, Object> updates) {
        return repository.findById(id).map(treino -> {
            if (updates.containsKey("idAluno")) treino.setIdAluno((Integer) updates.get("idAluno"));
            if (updates.containsKey("nome")) treino.setNome((String) updates.get("nome"));
            if (updates.containsKey("dataCriacao")) treino.setData((Date) updates.get("dataCriacao"));
            if (updates.containsKey("observacoes")) treino.setObs((String) updates.get("observacoes"));
            return repository.save(treino);
        }).orElse(null);
    }
}