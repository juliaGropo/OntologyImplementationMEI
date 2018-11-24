package org.ontology.tcc.entities.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Optional;

public class AtividadeResponse {

    @JsonProperty("codigoCNAE")
    private String codigoCNAE;

    @JsonProperty("resourceAtividade")
    private String resourceAtividade;

    @JsonProperty("classeAtividade")
    private String classeAtividade;

    @JsonProperty("descricao")
    private String descricao;

    @JsonProperty("locais")
    private List<String> locais;

    @JsonProperty("produtos")
    private List<String> produtos;

    @JsonProperty("servicos")
    private List<String> servicos;

    @JsonProperty("ocupacoes")
    private List<String> ocupacoes;

    @JsonProperty("locaisExc")
    private List<String> locaisExc;

    @JsonProperty("produtosExc")
    private List<String> produtosExc;

    @JsonProperty("servicosExc")
    private List<String> servicosExc;

    @JsonProperty("ocupacoesExc")
    private List<String> ocupacoesExc;

    public AtividadeResponse() {

    }

    public AtividadeResponse(Optional<String> descricao, Optional<String> cnae) {
        this.descricao = descricao.isPresent() ? descricao.get() : null;
        this.codigoCNAE = cnae.isPresent() ? cnae.get() : null;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCodigoCNAE() {
        return codigoCNAE;
    }

    public void setCodigoCNAE(String codigoCNAE) {
        this.codigoCNAE = codigoCNAE;
    }

    public String getResourceAtividade() {
        return resourceAtividade;
    }

    public void setResourceAtividade(String resourceAtividade) {
        this.resourceAtividade = resourceAtividade;
    }

    public List<String> getLocais() {
        return locais;
    }

    public void setLocais(List<String> locais) {
        this.locais = locais;
    }

    public List<String> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<String> produtos) {
        this.produtos = produtos;
    }

    public List<String> getServicos() {
        return servicos;
    }

    public void setServicos(List<String> servicos) {
        this.servicos = servicos;
    }

    public List<String> getOcupacoes() {
        return ocupacoes;
    }

    public void setOcupacoes(List<String> ocupacoes) {
        this.ocupacoes = ocupacoes;
    }

    public List<String> getLocaisExc() {
        return locaisExc;
    }

    public void setLocaisExc(List<String> locaisExc) {
        this.locaisExc = locaisExc;
    }

    public List<String> getProdutosExc() {
        return produtosExc;
    }

    public void setProdutosExc(List<String> produtosExc) {
        this.produtosExc = produtosExc;
    }

    public List<String> getServicosExc() {
        return servicosExc;
    }

    public void setServicosExc(List<String> servicosExc) {
        this.servicosExc = servicosExc;
    }

    public List<String> getOcupacoesExc() {
        return ocupacoesExc;
    }

    public void setOcupacoesExc(List<String> ocupacoesExc) {
        this.ocupacoesExc = ocupacoesExc;
    }

    public String getClasseAtividade() {
        return classeAtividade;
    }

    public void setClasseAtividade(String classeAtividade) {
        this.classeAtividade = classeAtividade;
    }
}
