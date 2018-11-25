package org.ontology.tcc.controller;

import org.apache.jena.ontology.OntModel;
import org.ontology.tcc.service.OntologyService;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/ontologia")
public class OntologyController {

    private final OntologyService ontologyService;

    @Autowired
    public OntologyController(OntologyService ontologyService) {
        this.ontologyService = ontologyService;
    }

    @GetMapping
    public ResponseEntity<List<File>> retornarTodasVersoes() throws OWLOntologyCreationException {

        List<File> files = new ArrayList<>();

        files = ontologyService.listarVersoes();

        return new ResponseEntity(files, HttpStatus.OK);
    }
}
