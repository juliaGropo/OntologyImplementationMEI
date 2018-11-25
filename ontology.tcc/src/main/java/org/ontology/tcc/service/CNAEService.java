package org.ontology.tcc.service;

import org.apache.jena.ontology.*;
import org.ontology.tcc.entities.response.CNAE;
import org.ontology.tcc.resources.MEIResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@Service
public class CNAEService {

    public CNAE cadastrarCNAE(CNAE cnae, OntModel ontology) throws IOException {

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

        String classeElemento = MEIResource.CLASS_CONJUNTOCNAE;
        String id = MEIResource.PROP_CONJUNTOCODIGO;
        String desc = MEIResource.PROP_CONJUNTODESCRICAO;

        OntClass cnaeClass = ontology.getOntClass(classeElemento);
        Individual cnaeIndividual = cnaeClass.createIndividual(MEIResource.ONTOLOGY + cnae.getResource());
        DatatypeProperty propertyId = ontology.getDatatypeProperty(id);
        DatatypeProperty propertyDesc = ontology.getDatatypeProperty(desc);

        cnaeIndividual.addProperty(propertyId, cnae.getCodigo());
        cnaeIndividual.addProperty(propertyDesc, cnae.getDescricao());

        String tripleProperty = "";

        switch (cnae.getTipo()){
            case "Seção":
                tripleProperty = MEIResource.PROP_GENERIC;
                break;
            case "Divisão":
                tripleProperty = MEIResource.PROP_TEMSECAO;
                break;
            case "Grupo":
                tripleProperty = MEIResource.PROP_TEMDIVISAO;
                break;
            case "Classe":
                tripleProperty = MEIResource.PROP_TEMGRUPO;
                break;
            case "Subclasse":
                tripleProperty = MEIResource.PROP_TEMCLASSE;
                break;
        }

        ObjectProperty objTripleProperty = ontology.getObjectProperty(tripleProperty);
        Individual tripleIndividual = ontology.getIndividual(MEIResource.ONTOLOGY + cnae.getCnaeSuperior());

        ontology.add(cnaeIndividual, objTripleProperty, tripleIndividual);

        ClassLoader classLoader = this.getClass().getClassLoader();
        String file = classLoader.getResource("ontology_source/tcc_mei_v2.0.owl").getFile();

        PrintStream p = new PrintStream(file);
        ontology.writeAll(p, "RDF/XML", null);
        p.close();

        return cnae;
    }
}
