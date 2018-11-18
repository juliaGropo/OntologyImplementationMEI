package org.ontology.tcc.service;

import org.apache.jena.ontology.Individual;
import org.apache.jena.ontology.OntClass;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Resource;
import org.ontology.tcc.entities.response.AtividadeResponse;
import org.ontology.tcc.entities.response.InformacaoAtividadeResponse;
import org.ontology.tcc.resources.MEIResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
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
                            .getPropertieValue(resource, MEIResource.PROP_ATIVIDADEELEMENTODESCRICAO).stream().findAny();

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
                            .getPropertieValue(resource, MEIResource.PROP_ATIVIDADEELEMENTODESCRICAO).stream().findAny();

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
                            .getPropertieValue(resource, MEIResource.PROP_ATIVIDADEELEMENTODESCRICAO).stream().findAny();

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
                            .getPropertieValue(resource, MEIResource.PROP_OCUPACAONOME).stream().findAny();

                    return local.get();
                }).collect(Collectors.toList());

        return ocupacoesList;
    }

    public InformacaoAtividadeResponse listAtividadesByTermos(List<String> termos, OntModel ontology) throws IOException {

        OntologyService ontologyService = new OntologyService();

        List<String> termosFinded = ontologyService.filterTermosFindedInOntology(MEIResource.PROP_LABEL, termos, ontology);
        if(termosFinded.isEmpty()) {
            return new InformacaoAtividadeResponse();
        }

        List<RDFNode> nodes = ontologyService.listRDFNodesByPropertieValue(MEIResource.PROP_LABEL, termos, ontology);
        List<Individual> individuals = ontologyService.listindividualsByClass(MEIResource.CLASS_ATIVIDADE, ontology);
        List<Resource> resources = individuals.stream().map(i -> i.asResource()).collect(Collectors.toList());

        resources = ontologyService.filterResourceWithAllPropertieParams(MEIResource.PROP_TEMELEMENTO, resources, nodes, ontology);
        resources = ontologyService.filterResourceNotHasExcecaoToParams(resources, nodes, termosFinded, ontology);
        List<AtividadeResponse> atividadesresponse = resources.stream()
                .map(resource -> {
                    Optional<String> subclasseCodigo = ontologyService.getPropertieValueOfResourceOfPropertie(resource, MEIResource.PROP_PERMITIDAPOR, MEIResource.PROP_CONJUNTOCODIGO).stream().findAny();
                    Optional<String> descricaoAtividade = ontologyService.getPropertieValue(resource, MEIResource.PROP_ATIVIDADEDESCRICAO).stream().findAny();
                    return new AtividadeResponse(descricaoAtividade, subclasseCodigo);
                })
                .collect(Collectors.toList());
        return new InformacaoAtividadeResponse(termosFinded, atividadesresponse);
    }
}
