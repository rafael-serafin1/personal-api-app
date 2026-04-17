package com.example.demo.model;

import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Entity
@Table(name = "personal")   // sensitive case... precisa do \"
public class Personal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_personal") private Integer idPersonal;
    private String nome;
    private String email;
    private String telefone;
    @Column(name = "registro_prof") private String registroProf;

    // getters
    // em orde
    public Integer getIdPersonal() {
        return idPersonal;
    }
    public String getNome() {
        return nome;
    }
    public String getEmail() {
        return email;
    }
    public String getTelefone() {
        return telefone;
    }
    public String getRegistroProf() {
        return registroProf;
    }

    // setters
    // em ordem
    public void setIdPersonal(Integer IdPersonal) {
        this.idPersonal = IdPersonal;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public void setRegistroProf(String registroProf) {
        this.registroProf = registroProf;
    }
}