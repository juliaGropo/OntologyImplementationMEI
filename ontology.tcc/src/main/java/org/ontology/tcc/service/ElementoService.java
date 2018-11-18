package org.ontology.tcc.service;

import org.apache.jena.ontology.*;
import org.ontology.tcc.entities.response.Elemento;
import org.ontology.tcc.resources.MEIResource;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.PrintStream;

@Service
public class ElementoService {

    public void createElemento(Elemento elemento, OntModel ontology) throws FileNotFoundException {

        String classeElemento = "";
        String property = MEIResource.PROP_ATIVIDADEELEMENTODESCRICAO;

        switch (elemento.getClasseElemento()) {

            case "Local":
                classeElemento = MEIResource.ATIVIDADE_LOCAL;
                break;
            case "Produto":
                classeElemento = MEIResource.ATIVIDADE_PRODUTO;
                break;
            case "Serviço":
                classeElemento = MEIResource.ATIVIDADE_SERVICO;
                break;
            case "Ocupação":
                classeElemento = MEIResource.ATIVIDADE_OCUPACAO;
                property = MEIResource.PROP_OCUPACAONOME;
                break;
        }

        OntClass elementoClass = ontology.getOntClass(classeElemento);
        Individual elementoIndividual = elementoClass.createIndividual(MEIResource.ONTOLOGY + elemento.getResourceCode());
        DatatypeProperty propertyDesc = ontology.getDatatypeProperty(property);
        elementoIndividual.addProperty(propertyDesc, elemento.getDescricaoOficial());

        for (String descricaoAdicional : elemento.getDescricoesAdicionais()) {
            elementoIndividual.addProperty(propertyDesc, descricaoAdicional);
        }

        ObjectProperty generico = ontology.getObjectProperty(MEIResource.PROP_GENERIC);
        Individual genericoIndividual = ontology.getIndividual(MEIResource.PROP_GENERIC);

        ontology.add(elementoIndividual, generico, genericoIndividual);

        ClassLoader classLoader = this.getClass().getClassLoader();
        String file = classLoader.getResource("ontology_source/tcc_mei_v2.0.owl").getFile();

        PrintStream p = new PrintStream(file);
        ontology.writeAll(p, "RDF/XML", null);
        p.close();
    }
}
