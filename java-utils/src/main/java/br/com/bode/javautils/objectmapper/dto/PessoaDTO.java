package br.com.bode.javautils.objectmapper.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;


public class PessoaDTO implements Serializable {

    @JsonProperty("Nome")
    private String nome;

    @JsonProperty("Idade")
    private String idade;

    @JsonProperty("Documento")
    private String documento;

    public PessoaDTO() {
    }

    public PessoaDTO(String nome, String idade, String documento) {
        this.nome = nome;
        this.idade = idade;
        this.documento = documento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    @Override
    public String toString() {
        return "PessoaDTO{" +
                "nome='" + nome + '\'' +
                ", idade='" + idade + '\'' +
                ", documento='" + documento + '\'' +
                '}';
    }
}