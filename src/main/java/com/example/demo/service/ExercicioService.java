package com.example.demo.service;

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
}