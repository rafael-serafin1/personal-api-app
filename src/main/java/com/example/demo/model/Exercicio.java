package com.example.demo.model;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "exercicio") 
public class Exercicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_exercicio") private Integer idExercicio;
    @Column(name = "id_treino") private Integer idTreino;
    private String nome;
    private Integer series;
    private String repeticoes;
    private String carga;
    private String descanso;
    private Integer ordem;

    public Integer getIdExercicio() {
        return idExercicio;
    }
    public Integer getIdTreino() {
        return idTreino;
    }
    public String getNome() {
        return nome;
    }
    public Integer getSeries() {
        return series;
    }
    public String getRepeticoes() {
        return repeticoes;
    }
    public String getCarga() {
        return carga;
    }
    public String getDescanso() {
        return descanso;
    }
    public Integer getOrdem() {
        return ordem;
    }

    public void setIdTreino(Integer idTreino) {
        this.idTreino = idTreino;
    }
    public void setIdExercicio(Integer idExercicio) {
        this.idExercicio = idExercicio;
    }
    public void setNome(String nome) {
        this.nome = nome;
    } 
    public void setSeries(Integer series) {
        this.series = series;
    }
    public void setRepeticoes(String repeticoes) {
        this.repeticoes = repeticoes;
    }
    public void setCarga(String carga) {
        this.carga = carga;
    }
    public void setDescanso(String descanso) {
        this.descanso = descanso;
    }
    public void setOrdem(Integer ordem) {
        this.ordem = ordem;
    }
}
