package br.com.bode.javautils.objectmapper.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

    @JsonProperty("nome")
    private String nome;

    @JsonProperty("idade")
    private Long idade;

    @JsonProperty("documento")
    private List<Documento> documento = new ArrayList<>();

    @JsonProperty("endereco")
    private Endereco endereco;

    public Cliente() {
    }

    public Cliente(String nome, Long idade, List<Documento> documento, Endereco endereco) {
        this.nome = nome;
        this.idade = idade;
        this.documento = documento;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getIdade() {
        return idade;
    }

    public void setIdade(Long idade) {
        this.idade = idade;
    }

    public List<Documento> getDocumento() {
        return documento;
    }

    public void setDocumento(List<Documento> documento) {
        this.documento.addAll(documento);
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", documento=" + documento +
                ", endereco=" + endereco +
                '}';
    }
}
