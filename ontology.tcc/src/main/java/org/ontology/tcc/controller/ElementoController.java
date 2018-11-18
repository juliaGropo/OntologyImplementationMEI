package org.ontology.tcc.controller;

import org.apache.jena.ontology.Individual;
import org.apache.jena.ontology.OntClass;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.vocabulary.OWL2;
import org.apache.jena.vocabulary.RDFS;
import org.ontology.tcc.entities.response.Elemento;
import org.ontology.tcc.service.ElementoService;
import org.ontology.tcc.service.OntologyService;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/elementos")
public class ElementoController {

    private final OntologyService ontologyService;

    private final ElementoService elementoService;

    @Autowired
    public ElementoController(OntologyService ontologyService, ElementoService elementoService) {
        this.ontologyService = ontologyService;
        this.elementoService = elementoService;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public HttpStatus cadastrarElemento(@RequestBody Elemento elemento) throws FileNotFoundException {
        OntModel ontology = ontologyService.carregaOntologia();

        elementoService.createElemento(elemento, ontology);

        return HttpStatus.OK;
    }

    /*@GetMapping
    public ResponseEntity<Elemento> cadastrarElemento() throws OWLOntologyCreationException, OWLOntologyStorageException, IOException {

        Elemento elemento = new Elemento();
        elemento.setDescricaoOficial("Teste");
        elemento.setResourceCode("elemento_teste");
        List<String> descricoes = new ArrayList<>();
        descricoes.add("teste1");
        descricoes.add("teste2");
        descricoes.add("teste3");
        elemento.setDescricoesAdicionais(descricoes);

        OntModel ontology = ontologyService.carregaOntologia();

        return new ResponseEntity(elemento, HttpStatus.OK);
    }*/
}
