package org.ontology.tcc.controller;

import org.apache.jena.ontology.OntModel;
import org.ontology.tcc.service.AtividadeService;
import org.ontology.tcc.service.OntologyService;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/produtos")
public class ProdutosController {

    private final OntologyService ontologyService;

    private final AtividadeService atividadeService;

    @Autowired
    public ProdutosController(OntologyService ontologyService, AtividadeService atividadeService) {
        this.ontologyService = ontologyService;
        this.atividadeService = atividadeService;
    }

    @GetMapping
    public ResponseEntity<List<String>> retornarTodosProdutos() throws OWLOntologyCreationException {

        OntModel ontology = ontologyService.carregaOntologia();

        List<String> list = atividadeService.retornaTodosProdutos(ontology);

        return new ResponseEntity(list, HttpStatus.OK);
    }
}
