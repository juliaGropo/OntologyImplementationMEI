package org.ontology.tcc.controller;

import org.apache.jena.ontology.OntModel;
import org.ontology.tcc.entities.response.CNAE;
import org.ontology.tcc.service.CNAEService;
import org.ontology.tcc.service.OntologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.io.IOException;

@RestController
@RequestMapping("api/v1/cnae")
public class CNAEController {

    private final OntologyService ontologyService;

    private final CNAEService cnaeService;

    @Autowired
    public CNAEController(OntologyService ontologyService, CNAEService cnaeService) {
        this.ontologyService = ontologyService;
        this.cnaeService = cnaeService;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<CNAE> cadastrarCNAE(@RequestBody CNAE cnae) throws IOException {

        OntModel ontology = ontologyService.carregaOntologia();

        cnaeService.cadastrarCNAE(cnae, ontology);

        return new ResponseEntity(cnae, HttpStatus.OK);
    }
}
