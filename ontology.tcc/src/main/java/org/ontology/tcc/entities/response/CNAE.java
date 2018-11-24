package org.ontology.tcc.entities.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CNAE {

    @JsonProperty("codigo")
    String codigo;

    @JsonProperty("tipo")
    String tipo;

    @JsonProperty("resource")
    String resource;

    @JsonProperty("descricao")
    String descricao;

    @JsonProperty("cnaeSuperior")
    String cnaeSuperior;

    public String getCnaeSuperior() {
        return cnaeSuperior;
    }

    public void setCnaeSuperior(String cnaeSuperior) {
        this.cnaeSuperior = cnaeSuperior;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
