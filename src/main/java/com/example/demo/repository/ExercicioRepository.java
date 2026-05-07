package com.example.demo.repository;

import java.util.*;
import com.example.demo.model.Exercicio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExercicioRepository extends JpaRepository<Exercicio, Integer> {
    List<Exercicio> findByIdTreino(Integer idTreino);
}
