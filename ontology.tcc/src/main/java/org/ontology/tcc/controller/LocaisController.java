package org.ontology.tcc.controller;

import org.apache.jena.ontology.OntModel;
import org.ontology.tcc.entities.response.AtividadeResponse;
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
@RequestMapping("api/v1/locais")
public class LocaisController {

    private final OntologyService ontologyService;

    private final AtividadeService atividadeService;

    @Autowired
    public LocaisController(OntologyService ontologyService, AtividadeService atividadeService) {
        this.ontologyService = ontologyService;
        this.atividadeService = atividadeService;
    }

    @GetMapping
    public ResponseEntity<List<String>> retornarTodosLocais() throws OWLOntologyCreationException {

        OntModel ontology = ontologyService.carregaOntologia();

        List<String> list = atividadeService.retornaTodosLocais(ontology);

        return new ResponseEntity(list, HttpStatus.OK);
    }
}
