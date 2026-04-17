package com.example.demo.model;

import java.sql.Date;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "aluno") 
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_aluno") private Integer idAluno;
    @Column(name = "id_personal") private Integer idPersonal;
    private String nome;
    @Column(name = "data_nascimento") private Date data;
    private Double peso;
    private Double altura;
    private String objetivo;


    public Integer getIdAluno() {
        return idAluno;
    }
    public Integer getIdPersonal() {
        return idPersonal;
    }
    public String getNome() {
        return nome;
    }
    public Date getData() {
        return data;
    }
    public Double getPeso() {
        return peso;
    }
    public Double getAltura() {
        return altura;
    }
    public String getObjetivo() {
        return objetivo;
    }

    public void setIdAluno(Integer id) {
        this.idAluno = id;
    }
    public void setIdPersonal(Integer id) {
        this.idPersonal = id;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setData(Date data){
        this.data = data;
    }
    public void setPeso(Double peso) {
        this.peso = peso;
    }
    public void setAltura(Double h) {
        this.altura = h;
    }
    public void setObjetivo(String obj) {
        this.objetivo = obj;
    }
}