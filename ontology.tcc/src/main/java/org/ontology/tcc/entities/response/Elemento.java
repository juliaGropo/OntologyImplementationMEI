package org.ontology.tcc.entities.response;

import java.util.List;

public class Elemento {

    String classeElemento;
    String descricaoOficial;
    String resourceCode;
    List<String> descricoesAdicionais;

    public String getClasseElemento() {
        return classeElemento;
    }

    public void setClasseElemento(String classeElemento) {
        this.classeElemento = classeElemento;
    }

    public String getDescricaoOficial() {
        return descricaoOficial;
    }

    public void setDescricaoOficial(String descricaoOficial) {
        this.descricaoOficial = descricaoOficial;
    }

    public String getResourceCode() {
        return resourceCode;
    }

    public void setResourceCode(String resourceCode) {
        this.resourceCode = resourceCode;
    }

    public List<String> getDescricoesAdicionais() {
        return descricoesAdicionais;
    }

    public void setDescricoesAdicionais(List<String> descricoesAdicionais) {
        this.descricoesAdicionais = descricoesAdicionais;
    }
}
