package org.ontology.tcc.service;

import org.apache.jena.ontology.*;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Resource;
import org.ontology.tcc.entities.response.AtividadeResponse;
import org.ontology.tcc.entities.response.InformacaoAtividadeResponse;
import org.ontology.tcc.resources.MEIResource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AtividadeService {

    public List<AtividadeResponse> retornaTodasAtividades(OntModel ontology) {

        OntologyService ontologyService = new OntologyService();

        OntClass atividadeClass = ontology.getOntClass
                ("http://www.semanticweb.org/gabriel/ontologies/2017/8/mei#Atividade");

        List<Individual> list = ontology.listIndividuals(atividadeClass).toList();

        List<AtividadeResponse> atividadeResponseList = list.stream()
                .map(resource -> {
                    Optional<String> subclasseCodigo = ontologyService.getPropertieValueOfResourceOfPropertie(resource,
                            MEIResource.PROP_PERMITIDAPOR, MEIResource.PROP_CONJUNTOCODIGO).stream().findAny();

                    Optional<String> descricaoAtividade = ontologyService
                            .getPropertieValue(resource, MEIResource.PROP_ATIVIDADEDESCRICAO).stream().findAny();

                    return new AtividadeResponse(descricaoAtividade, subclasseCodigo);

                }).collect(Collectors.toList());

        return atividadeResponseList;

    }

    public List<String> retornaTodosLocais(OntModel ontology) {

        OntologyService ontologyService = new OntologyService();

        OntClass atividadeClass = ontology.getOntClass
                ("http://www.semanticweb.org/gabriel/ontologies/2017/8/mei#AtividadeLocal");

        List<Individual> list = ontology.listIndividuals(atividadeClass).toList();

        List<String> locaisList = list.stream()
                .map(resource -> {
                    Optional<String> local = ontologyService
                            .getPropertieValue(resource, MEIResource.PROP_DESCRICAO).stream().findAny();

                    return local.get();
                }).collect(Collectors.toList());

        return locaisList;
    }

    public List<String> retornaTodosProdutos(OntModel ontology) {

        OntologyService ontologyService = new OntologyService();

        OntClass atividadeClass = ontology.getOntClass
                ("http://www.semanticweb.org/gabriel/ontologies/2017/8/mei#AtividadeProduto");

        List<Individual> list = ontology.listIndividuals(atividadeClass).toList();

        List<String> produtosList = list.stream()
                .map(resource -> {
                    Optional<String> local = ontologyService
                            .getPropertieValue(resource, MEIResource.PROP_DESCRICAO).stream().findAny();

                    return local.get();
                }).collect(Collectors.toList());

        return produtosList;
    }

    public List<String> retornaTodosServicos(OntModel ontology) {

        OntologyService ontologyService = new OntologyService();

        OntClass atividadeClass = ontology.getOntClass
                ("http://www.semanticweb.org/gabriel/ontologies/2017/8/mei#AtividadeServico");

        List<Individual> list = ontology.listIndividuals(atividadeClass).toList();

        List<String> servicosList = list.stream()
                .map(resource -> {
                    Optional<String> local = ontologyService
                            .getPropertieValue(resource, MEIResource.PROP_DESCRICAO).stream().findAny();

                    return local.get();
                }).collect(Collectors.toList());

        return servicosList;
    }

    public List<String> retornaTodasOcupacoes(OntModel ontology) {

        OntologyService ontologyService = new OntologyService();

        OntClass atividadeClass = ontology.getOntClass
                ("http://www.semanticweb.org/gabriel/ontologies/2017/8/mei#Ocupacao");

        List<Individual> list = ontology.listIndividuals(atividadeClass).toList();

        List<String> ocupacoesList= list.stream()
                .map(resource -> {
                    Optional<String> local = ontologyService
                            .getPropertieValue(resource, MEIResource.PROP_DESCRICAO).stream().findAny();

                    return local.get();
                }).collect(Collectors.toList());

        return ocupacoesList;
    }

    public InformacaoAtividadeResponse listAtividadesByTermos(List<String> termos, OntModel ontology) throws IOException {

        OntologyService ontologyService = new OntologyService();

        List<String> termosFinded = ontologyService.filterTermosFindedInOntology(MEIResource.PROP_ATIVIDADEELEMENTODESCRICAO, termos, ontology);
        if(termosFinded.isEmpty()) {
            return new InformacaoAtividadeResponse();
        }

        List<RDFNode> nodes = ontologyService.listRDFNodesByPropertieValue(MEIResource.PROP_ATIVIDADEELEMENTODESCRICAO, termos, ontology);
        List<Individual> individuals = ontologyService.listindividualsByClass(MEIResource.CLASS_ATIVIDADE, ontology);
        List<Resource> resources = individuals.stream().map(i -> i.asResource()).collect(Collectors.toList());

        resources = ontologyService.filterResourceWithAllPropertieParams(MEIResource.PROP_TEMELEMENTO, resources, nodes, ontology);
        resources = ontologyService.filterResourceNotHasExcecaoToParams(resources, nodes, termosFinded, ontology);
        List<AtividadeResponse> atividadesresponse = resources.stream()
                .map(resource -> {
                    Optional<String> subclasseCodigo = ontologyService.getPropertieValueOfResourceOfPropertie(resource, MEIResource.PROP_PERMITIDAPOR,
                            MEIResource.PROP_CONJUNTOCODIGO).stream().findAny();
                    Optional<String> descricaoAtividade = ontologyService.getPropertieValue(resource, MEIResource.PROP_ATIVIDADEDESCRICAO).stream().findAny();
                    return new AtividadeResponse(descricaoAtividade, subclasseCodigo);
                })
                .collect(Collectors.toList());
        return new InformacaoAtividadeResponse(termosFinded, atividadesresponse);
    }

    public HttpStatus cadastrarAtividade(AtividadeResponse atividade, OntModel ontology) throws FileNotFoundException {

        OntologyService ontologyService = new OntologyService();

        OntClass atividadeClass = ontology.getOntClass(MEIResource.CLASS_ATIVIDADE);
        Individual atividadeIndividual = atividadeClass.createIndividual(MEIResource.ONTOLOGY + atividade.getResourceAtividade());
        DatatypeProperty propertyCod = ontology.getDatatypeProperty(MEIResource.PROP_ATIVIDADEDESCRICAO);
        DatatypeProperty propertyDesc = ontology.getDatatypeProperty(MEIResource.PROP_ATIVIDADEDESCRICAO);
        atividadeIndividual.addProperty(propertyDesc, atividade.getDescricao());

        ObjectProperty propertyLocal = ontology.getObjectProperty(MEIResource.PROP_TEMLOCAL);
        ObjectProperty propertyProduto = ontology.getObjectProperty(MEIResource.PROP_TEMPRODUTO);
        ObjectProperty propertyServico = ontology.getObjectProperty(MEIResource.PROP_TEMSERVICO);
        ObjectProperty propertyOcupacao = ontology.getObjectProperty(MEIResource.PROP_TEMOCUPACAO);

        ObjectProperty propertyLocalExc = ontology.getObjectProperty(MEIResource.PROP_EXCLOCAL);
        ObjectProperty propertyProdutoExc = ontology.getObjectProperty(MEIResource.PROP_EXCPRODUTO);
        ObjectProperty propertyServicoExc= ontology.getObjectProperty(MEIResource.PROP_EXCSERVICO);
        ObjectProperty propertyOcupacaoExc = ontology.getObjectProperty(MEIResource.PROP_EXCOCUPACAO);

        ObjectProperty propertyPermitida = ontology.getObjectProperty(MEIResource.PROP_PERMITIDAPOR);
        Individual classeIndividual = ontology.getIndividual(MEIResource.ONTOLOGY + "cnae_subclasse_" + atividade.getClasseAtividade());
        atividadeIndividual.addProperty(propertyPermitida, classeIndividual);
        ontology.add(atividadeIndividual, propertyPermitida, classeIndividual);

        if (atividade.getLocais() != null) {
            for (String local : atividade.getLocais()) {
                Individual localIndividual = ontology.getIndividual(MEIResource.ONTOLOGY + "elemento_" + local);
                atividadeIndividual.addProperty(propertyLocal, localIndividual);
                ontology.add(atividadeIndividual, propertyLocal, localIndividual);
            }
        }

        if (atividade.getLocaisExc() != null) {
            for (String local : atividade.getLocaisExc()) {
                Individual localIndividual = ontology.getIndividual(MEIResource.ONTOLOGY + "elemento_" + local);
                atividadeIndividual.addProperty(propertyLocalExc, localIndividual);
                ontology.add(atividadeIndividual, propertyLocalExc, localIndividual);
            }
        }

        if (atividade.getProdutos() != null) {
            for (String produto : atividade.getProdutos()) {
                Individual produtoIndividual = ontology.getIndividual(MEIResource.ONTOLOGY + "elemento_" + produto);
                atividadeIndividual.addProperty(propertyProduto, produtoIndividual);
                ontology.add(atividadeIndividual, propertyProduto, produtoIndividual);
            }
        }

        if (atividade.getProdutosExc() != null) {
            for (String produto : atividade.getProdutosExc()) {
                Individual produtoIndividual = ontology.getIndividual(MEIResource.ONTOLOGY + "elemento_" + produto);
                atividadeIndividual.addProperty(propertyProdutoExc, produtoIndividual);
                ontology.add(atividadeIndividual, propertyProdutoExc, produtoIndividual);
            }
        }

        if (atividade.getServicos() != null) {
            for (String servico : atividade.getServicos()) {
                Individual servicoIndividual = ontology.getIndividual(MEIResource.ONTOLOGY + "elemento_" + servico);
                atividadeIndividual.addProperty(propertyServico, servicoIndividual);
                ontology.add(atividadeIndividual, propertyServico, servicoIndividual);
            }
        }

        if (atividade.getServicosExc() != null) {
            for (String servico : atividade.getServicosExc()) {
                Individual servicoIndividual = ontology.getIndividual(MEIResource.ONTOLOGY + "elemento_" + servico);
                atividadeIndividual.addProperty(propertyServicoExc, servicoIndividual);
                ontology.add(atividadeIndividual, propertyServicoExc, servicoIndividual);
            }
        }

        if (atividade.getOcupacoes() != null) {
            for (String ocupacao : atividade.getOcupacoes()) {
                Individual ocupacaoIndividual = ontology.getIndividual(MEIResource.ONTOLOGY + "ocupacao_" + ocupacao);
                atividadeIndividual.addProperty(propertyOcupacao, ocupacaoIndividual);
                ontology.add(atividadeIndividual, propertyOcupacao, ocupacaoIndividual);
            }
        }

        if (atividade.getOcupacoesExc() != null) {
            for (String ocupacao : atividade.getOcupacoesExc()) {
                Individual ocupacaoIndividual = ontology.getIndividual(MEIResource.ONTOLOGY + "ocupacao_" + ocupacao);
                atividadeIndividual.addProperty(propertyOcupacaoExc, ocupacaoIndividual);
                ontology.add(atividadeIndividual, propertyOcupacaoExc, ocupacaoIndividual);
            }
        }

        ClassLoader classLoader = this.getClass().getClassLoader();
        String file = classLoader.getResource("ontology_source/tcc_mei_v2.0.owl").getFile();

        PrintStream p = new PrintStream(file);
        ontology.writeAll(p, "RDF/XML", null);
        p.close();

        return  HttpStatus.OK;
    }
}
