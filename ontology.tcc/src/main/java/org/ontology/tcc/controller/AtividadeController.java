package org.ontology.tcc.controller;

import org.apache.jena.ontology.OntModel;
import org.ontology.tcc.entities.response.AtividadeResponse;
import org.ontology.tcc.entities.response.InformacaoAtividadeResponse;
import org.ontology.tcc.service.AtividadeService;
import org.ontology.tcc.service.OntologyService;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javax.ws.rs.core.Response;

@RestController
@RequestMapping("api/v1/atividades")
public class AtividadeController {

    private final OntologyService ontologyService;

    private final AtividadeService atividadeService;

    @Autowired
    public AtividadeController(OntologyService ontologyService, AtividadeService atividadeService) {
        this.ontologyService = ontologyService;
        this.atividadeService = atividadeService;
    }

    @GetMapping
    public ResponseEntity<List<AtividadeResponse>> consultarAtividades() throws OWLOntologyCreationException {

        OntModel ontology = ontologyService.carregaOntologia();

        List<AtividadeResponse> list = atividadeService.retornaTodasAtividades(ontology);

        return new ResponseEntity(list, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public HttpStatus cadastrarElemento(@RequestBody AtividadeResponse atividade) throws IOException {

        OntModel ontology = ontologyService.carregaOntologia();

        atividadeService.cadastrarAtividade(atividade, ontology);

        return HttpStatus.OK;
    }

    @RequestMapping(value = "/{termo}", method = RequestMethod.GET)
    public ResponseEntity<InformacaoAtividadeResponse> consultarAtividadesPorTermo(@PathVariable String termo) throws IOException {

        termo = termo != null ? termo.toLowerCase() : "";

        OntModel ontology = ontologyService.carregaOntologia();

        InformacaoAtividadeResponse atividadeResponse = atividadeService.listAtividadesByTermos(Arrays.asList(termo.split(" ")), ontology);

        return new ResponseEntity(atividadeResponse, HttpStatus.OK);
    }

    @RequestMapping(value = "/edicao/{codigo}", method = RequestMethod.GET)
    public ResponseEntity<AtividadeResponse> retornaAtividade(@PathVariable String codigo) {

        OntModel ontology = ontologyService.carregaOntologia();

        AtividadeResponse atividadeResponse = new AtividadeResponse();
        atividadeResponse.setResourceAtividade(codigo);

        atividadeResponse = atividadeService.retornaAtividade(atividadeResponse, ontology);

        return new ResponseEntity<>(atividadeResponse, HttpStatus.OK);
    }

    @RequestMapping(value = "/{codigo}", method = RequestMethod.DELETE)
    public HttpStatus deletaAtividade(@PathVariable String codigo) throws IOException {

        OntModel ontology = ontologyService.carregaOntologia();

        atividadeService.deleteAtividade(codigo, ontology);

        return HttpStatus.OK;
    }

}
