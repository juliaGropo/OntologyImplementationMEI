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

    @RequestMapping(value = "/{termo}", method = RequestMethod.GET)
    public Response consultarAtividadesPorTermo(@PathVariable String termo) throws IOException {

        termo = termo != null ? termo.toLowerCase() : "";

        OntModel ontology = ontologyService.carregaOntologia();

        InformacaoAtividadeResponse atividadeResponse = atividadeService.listAtividadesByTermos(Arrays.asList(termo.split(" ")), ontology);

        return Response.ok(atividadeService.listAtividadesByTermos(Arrays.asList(termo.split(" ")), ontology)).build();
    }
}
