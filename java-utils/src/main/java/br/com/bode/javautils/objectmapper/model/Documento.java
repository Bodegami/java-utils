package br.com.bode.javautils.objectmapper.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Documento {

    @JsonProperty("tipo")
    private String tipo;

    @JsonProperty("codigo")
    private String codigo;


    public Documento() {
    }

    public Documento(String tipo, String codigo) {
        this.tipo = tipo;
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Documento{" +
                "tipo='" + tipo + '\'' +
                ", codigo='" + codigo + '\'' +
                '}';
    }
}
