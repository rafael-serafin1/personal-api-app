package com.example.demo.service;

import java.util.Map;
import com.example.demo.model.Exercicio;
import com.example.demo.dto.ExercicioRequest;
import org.springframework.stereotype.Service;
import com.example.demo.repository.ExercicioRepository;

@Service
public class ExercicioService {
    private final ExercicioRepository repository;

    public ExercicioService(ExercicioRepository repository) {
        this.repository = repository;
    }

    public Exercicio criarExercicio(ExercicioRequest request) {
        Exercicio exercicio = new Exercicio();

        exercicio.setIdTreino(request.getIdTreino());
        exercicio.setNome(request.getNome());
        exercicio.setSeries(request.getSeries());
        exercicio.setRepeticoes(request.getRepeticoes());
        exercicio.setCarga(request.getCarga());
        exercicio.setDescanso(request.getDescanso());
        exercicio.setOrdem(request.getOrdem());

        return repository.save(exercicio);
    }

    public Exercicio atualizarExercicio(Integer id, ExercicioRequest request) {
        return repository.findById(id).map(exercicio -> {
            exercicio.setIdTreino(request.getIdTreino());
            exercicio.setNome(request.getNome());
            exercicio.setSeries(request.getSeries());
            exercicio.setRepeticoes(request.getRepeticoes());
            exercicio.setCarga(request.getCarga());
            exercicio.setDescanso(request.getDescanso());
            exercicio.setOrdem(request.getOrdem());
            return repository.save(exercicio);
        }).orElse(null);
    }

    public Exercicio atualizarParcialmente(Integer id, Map<String, Object> updates) {
        return repository.findById(id).map(exercicio -> {
            if (updates.containsKey("idTreino")) exercicio.setIdTreino((Integer) updates.get("idTreino"));
            if (updates.containsKey("nome")) exercicio.setNome((String) updates.get("nome"));
            if (updates.containsKey("series")) exercicio.setSeries((Integer) updates.get("series"));
            if (updates.containsKey("repeticoes")) exercicio.setRepeticoes((String) updates.get("repeticoes"));
            if (updates.containsKey("carga")) exercicio.setCarga((String) updates.get("carga"));
            if (updates.containsKey("descanso")) exercicio.setDescanso((String) updates.get("descanso"));
            if (updates.containsKey("ordem")) exercicio.setOrdem((Integer) updates.get("ordem"));
            return repository.save(exercicio);
        }).orElse(null);
    }
}