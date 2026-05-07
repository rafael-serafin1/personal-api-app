package com.example.demo.repository;

import java.util.*;
import com.example.demo.model.Treino;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TreinoRepository extends JpaRepository<Treino, Integer> {
    List<Treino> findByIdAluno(Integer idAluno);
}