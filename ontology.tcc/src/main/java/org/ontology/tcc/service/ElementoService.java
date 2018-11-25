package org.ontology.tcc.service;

import org.apache.jena.ontology.*;
import org.apache.jena.rdf.model.Statement;
import org.apache.jena.rdf.model.StmtIterator;
import org.ontology.tcc.entities.response.Elemento;
import org.ontology.tcc.resources.MEIResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class ElementoService {

    public void createElemento(Elemento elemento, OntModel ontology) throws IOException {

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

        Individual verificaElemento = ontology.getIndividual(MEIResource.ONTOLOGY + elemento.getResourceCode());

        ClassLoader classLoader = this.getClass().getClassLoader();
        String file = classLoader.getResource("ontology_source/tcc_mei_v2.0.owl").getFile();

        SimpleDateFormat formatoData = new SimpleDateFormat("yyyyMMdd");
        Calendar data = Calendar.getInstance();

        File arquivoAntigo = new File(classLoader.getResource("ontology_source/tcc_mei_v2.0.owl").getFile());
        File arquivoNovo = new File("C:\\Users\\Julia\\Documents\\OntologyImplementationMEI\\ontology.tcc\\target\\classes\\ontology_source\\versions\\tcc_mei_v2.0" + formatoData.format(data.getTime()) + ".owl");

        PrintStream p = new PrintStream(file);
        ontology.writeAll(p, "RDF/XML", null);
        p.close();

        OntologyService.copyFile(arquivoAntigo, arquivoNovo);

        if (verificaElemento != null) {

            verificaElemento.remove();

            ClassLoader classLoaderRemove = this.getClass().getClassLoader();
            String fileRemove = classLoaderRemove.getResource("ontology_source/tcc_mei_v2.0.owl").getFile();

            PrintStream pRemove = new PrintStream(fileRemove);
            ontology.writeAll(pRemove, "RDF/XML", null);
            pRemove.close();
        }

        DatatypeProperty propertyDesc = ontology.getDatatypeProperty(property);

        DatatypeProperty propertyDescPrincipal = ontology.getDatatypeProperty(MEIResource.PROP_DESCRICAO);
        elementoIndividual.addProperty(propertyDescPrincipal, elemento.getDescricaoOficial());
        elementoIndividual.addProperty(propertyDesc, elemento.getDescricaoOficial());

        for (String descricaoAdicional : elemento.getDescricoesAdicionais()) {
            elementoIndividual.addProperty(propertyDesc, descricaoAdicional);
        }

        ObjectProperty generico = ontology.getObjectProperty(MEIResource.PROP_GENERIC);
        Individual genericoIndividual = ontology.getIndividual(MEIResource.PROP_GENERIC);

        ontology.add(elementoIndividual, generico, genericoIndividual);

        ClassLoader newClassLoader = this.getClass().getClassLoader();
        String newFile = newClassLoader.getResource("ontology_source/tcc_mei_v2.0.owl").getFile();

        PrintStream newP = new PrintStream(newFile);
        ontology.writeAll(newP, "RDF/XML", null);
        newP.close();
    }

    public Elemento retornaElemento(Elemento elemento, OntModel ontology) {

        OntologyService ontologyService = new OntologyService();

        Individual elementoIndividual = ontology.getIndividual(MEIResource.ONTOLOGY + elemento.getResourceCode());

        StmtIterator it = elementoIndividual.listProperties();

        List<String> descricoes = new ArrayList<>();

        while ( it.hasNext()) {
            Statement s = (Statement) it.next();

            if (s.getObject().isLiteral()) {

                System.out.println(""+s.getLiteral().getLexicalForm().toString()+" type = "+s.getPredicate().getLocalName());

                if (s.getPredicate().getLocalName().equals("descricaoPrincipal"))
                    elemento.setDescricaoOficial(s.getLiteral().getLexicalForm().toString());
                else {
                    descricoes.add(s.getLiteral().getLexicalForm().toString());
                }

            } else {
                System.out.println("" + s.getObject().toString() + " type = " + s.getPredicate().getLocalName());
            }


        }
        System.out.println("\n");

        elemento.setDescricoesAdicionais(descricoes);

        return elemento;

    }

    public void deleteElemento(String codElemento, OntModel ontology) throws IOException {

        Individual verificaElemento = ontology.getIndividual(MEIResource.ONTOLOGY + codElemento);

        ClassLoader classLoaderRemove = this.getClass().getClassLoader();
        String fileRemove = classLoaderRemove.getResource("ontology_source/tcc_mei_v2.0.owl").getFile();

        SimpleDateFormat formatoData = new SimpleDateFormat("yyyyMMdd");
        Calendar data = Calendar.getInstance();

        File arquivoAntigo = new File(classLoaderRemove.getResource("ontology_source/tcc_mei_v2.0.owl").getFile());
        File arquivoNovo = new File("C:\\Users\\Julia\\Documents\\OntologyImplementationMEI\\ontology.tcc\\target\\classes\\ontology_source\\versions\\tcc_mei_v2.0" + formatoData.format(data.getTime()) + ".owl");

        PrintStream pRemove = new PrintStream(fileRemove);
        ontology.writeAll(pRemove, "RDF/XML", null);
        pRemove.close();

        OntologyService.copyFile(arquivoAntigo, arquivoNovo);

        if (verificaElemento != null) {
            verificaElemento.remove();

            ClassLoader classLoader = this.getClass().getClassLoader();
            String file = classLoader.getResource("ontology_source/tcc_mei_v2.0.owl").getFile();

            PrintStream p = new PrintStream(file);
            ontology.writeAll(p, "RDF/XML", null);
            p.close();
        }
    }
}
