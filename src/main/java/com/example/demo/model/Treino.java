package com.example.demo.model;

import java.sql.Date;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "treino")
public class Treino {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_treino") private Integer idTreino;
    @Column(name = "id_aluno") private Integer idAluno;
    @Column(name = "nome_treino") private String nome;
    @Column(name = "data_criacao") private Date data;
    private String observacoes;

    public Integer getIdTreino() {
        return idTreino;
    }
    public Integer getIdAluno() {
        return idAluno;
    }
    public String getNome() {
        return nome;
    }
    public Date getDataCriacao() {
        return data;
    }
    public String getObs() {
        return observacoes;
    }

    public void setIdTreino(Integer idTreino) {
        this.idTreino = idTreino;
    }
    public void setIdAluno(Integer idAluno) {
        this.idAluno = idAluno;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setData(Date data) {
        this.data = data;
    }
    public void setObs(String obs) {
        this.observacoes = obs;
    }
}
