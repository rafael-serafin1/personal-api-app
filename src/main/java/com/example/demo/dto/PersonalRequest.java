package com.example.demo.dto;

public class PersonalRequest {
    private String nome;
    private String email;
    private String telefone;
    private String registroProf;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getRegistroProf() {
        return registroProf;
    }

    public void setRegistroProf(String registroProf) {
        this.registroProf = registroProf;
    }
}