package org.ontology.tcc.controller;

import org.apache.jena.ontology.OntModel;
import org.ontology.tcc.entities.response.Elemento;
import org.ontology.tcc.service.ElementoService;
import org.ontology.tcc.service.OntologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.io.IOException;

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

    @RequestMapping(value = "/{classe}/{codigo}", method = RequestMethod.GET)
    public ResponseEntity<Elemento> retornaElemento(@PathVariable(value = "classe") String classe, @PathVariable(value = "codigo") String codigo) {

        OntModel ontology = ontologyService.carregaOntologia();

        Elemento elemento = new Elemento();
        elemento.setClasseElemento(classe);
        elemento.setResourceCode(codigo);

        elemento = elementoService.retornaElemento(elemento, ontology);

        return new ResponseEntity<>(elemento, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public HttpStatus cadastrarElemento(@RequestBody Elemento elemento) throws IOException {
        OntModel ontology = ontologyService.carregaOntologia();

        elementoService.createElemento(elemento, ontology);

        return HttpStatus.OK;
    }

    @RequestMapping(value = "/{codigo}", method = RequestMethod.DELETE)
    public HttpStatus deletaElemento(@PathVariable String codigo) throws IOException {

        OntModel ontology = ontologyService.carregaOntologia();

        elementoService.deleteElemento(codigo, ontology);

        return HttpStatus.OK;
    }
}
