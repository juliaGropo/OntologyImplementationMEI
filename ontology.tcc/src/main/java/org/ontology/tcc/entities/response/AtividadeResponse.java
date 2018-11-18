package org.ontology.tcc.entities.response;

import org.ontology.tcc.entities.impl.DefaultAtividade;
import org.protege.owl.codegeneration.inference.CodeGenerationInference;
import org.semanticweb.owlapi.model.IRI;

import java.util.List;
import java.util.Optional;

public class AtividadeResponse {

    private String codigoCNAE;
    private String descricao;

    /*private List<String> locais;

    private List<String> produtos;

    private List<String> servicos;

    private List<String> ocupacoes;

    private List<String> locaisExc;

    private List<String> produtosExc;

    private List<String> servicosExc;

    private List<String> ocupacoesExc;*/

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

    /*public List<String> getLocais() {
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
    }*/
}
