package com.example.demo.repository;

import java.util.*;
import com.example.demo.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {
    List<Aluno> findByIdPersonal(Integer idPersonal);
}

