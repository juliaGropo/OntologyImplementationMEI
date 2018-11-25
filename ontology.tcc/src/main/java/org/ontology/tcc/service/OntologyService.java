package org.ontology.tcc.service;

import org.apache.jena.ontology.Individual;
import org.apache.jena.ontology.OntClass;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.rdf.model.*;
import org.apache.jena.util.FileManager;
import org.mindswap.pellet.jena.PelletReasonerFactory;
import org.ontology.tcc.resources.MEIResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.channels.FileChannel;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class OntologyService {

    @Autowired
    public OntologyService() {

    }

    public OntModel carregaOntologia() {

        ClassLoader classLoader = this.getClass().getClassLoader();
        String url = classLoader.getResource("ontology_source/tcc_mei_v2.0.owl").getFile();
        InputStream inputStream = FileManager.get().open(url);

        OntModel ontModel = ModelFactory.createOntologyModel(PelletReasonerFactory.THE_SPEC.getLanguage());
        ontModel.read(inputStream, null);

        return ontModel;
    }

    public List<String> getPropertieValueOfResourceOfPropertie(Resource resource, String propertieURI, String propertieValueURI) {

        OntModel ontology = carregaOntologia();

        Property propertieOnt = ontology.getProperty(propertieURI);
        Property propertieValueOnt = ontology.getProperty(propertieValueURI);

        NodeIterator iterator = ontology.listObjectsOfProperty(resource, propertieOnt);

        List<RDFNode> values = iterator.toList().stream()
                .map(node -> ontology.listObjectsOfProperty(node.asResource(), propertieValueOnt))
                .flatMap(nodeIter -> nodeIter.toList().stream())
                .collect(Collectors.toList());

        return values.stream().map(RDFNode::toString).collect(Collectors.toList());
    }

    public List<String> getPropertieValue(Resource resource, String propertieURI) {

        OntModel ontology = carregaOntologia();

        Property propertieOnt = ontology.getProperty(propertieURI);
        NodeIterator iterator = ontology.listObjectsOfProperty(resource, propertieOnt);
        return iterator.toList().stream().map(node -> node.toString().toLowerCase()).collect(Collectors.toList());
    }

    public List<String> filterTermosFindedInOntology(String propertieURI, List<String> termos, OntModel ontology) throws IOException {

        Property propertieOnt = ontology.getProperty(propertieURI);
        return termos.stream()
                .filter(termo -> ontology.listSubjectsWithProperty(propertieOnt, termo).hasNext())
                .collect(Collectors.toList());
    }

    public List<RDFNode> listRDFNodesByPropertieValue(String propertieURI, List<String> values, OntModel ontology) throws IOException {

        Property propertieOnt = ontology.getProperty(propertieURI);
        List<RDFNode> nodes = values.stream()
                .map(label -> ontology.listSubjectsWithProperty(propertieOnt, label))
                .flatMap(ri -> ri.toList().stream())
                .distinct()
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
        return nodes;
    }

    public List<Individual> listindividualsByClass(String classSubjectURI, OntModel ontology) {

        OntClass classOnt = ontology.getOntClass(classSubjectURI);
        return ontology.listIndividuals(classOnt).toList();
    }

    public List<Resource> filterResourceWithAllPropertieParams(String propertieURI, List<Resource> individualsToFilter, List<RDFNode> params, OntModel ontology) throws IOException {

        Property propertieOnt = ontology.getProperty(propertieURI);
        return individualsToFilter.stream()
                .filter(individual -> ontology.listObjectsOfProperty(individual, propertieOnt).toList().containsAll(params))
                .collect(Collectors.toList());
    }

    public List<Resource> filterResourceNotHasExcecaoToParams(List<Resource> individualsToFilter, List<RDFNode> paramsResource, List<String> params, OntModel ontology) throws IOException {

        Property excetoElementoprop = ontology.getProperty(MEIResource.PROP_EXCETOELEMENTO);
        Property excetoCondicaoProp = ontology.getProperty(MEIResource.PROP_EXCETOCONDICAO);
        Property temElementoProp = ontology.getProperty(MEIResource.PROP_TEMELEMENTO);
        Property descricaoElementoProp = ontology.getProperty(MEIResource.PROP_ATIVIDADEELEMENTODESCRICAO);

        List<Resource> resourcesWithExcecao = paramsResource.stream()
                .map(param -> ontology.listResourcesWithProperty(excetoElementoprop, param))
                .flatMap(resIter -> resIter.toList().stream())
                .distinct()
                .collect(Collectors.toList());

        individualsToFilter = individualsToFilter.stream().filter(indivi -> {
            NodeIterator ni = ontology.listObjectsOfProperty(indivi, excetoCondicaoProp);
            return !ni.toList().stream().anyMatch(condicao -> {
                NodeIterator termosNodeIter = ontology.listObjectsOfProperty(condicao.asResource(), temElementoProp);
                return termosNodeIter.toList().stream().allMatch(termo -> {
                    NodeIterator descricaoNodeIter = ontology.listObjectsOfProperty(termo.asResource(), descricaoElementoProp);
                    return descricaoNodeIter.toList().stream().anyMatch(descr -> params.contains(descr.toString()));
                });
            });
        }).collect(Collectors.toList());

        individualsToFilter.removeAll(resourcesWithExcecao);
        return individualsToFilter;
    }

    public static void copyFile(File source, File destination) throws IOException {
        if (destination.exists())
            destination.delete();
        FileChannel sourceChannel = null;
        FileChannel destinationChannel = null;
        try {
            sourceChannel = new FileInputStream(source).getChannel();
            destinationChannel = new FileOutputStream(destination).getChannel();
            sourceChannel.transferTo(0, sourceChannel.size(),
                    destinationChannel);
        } finally {
            if (sourceChannel != null && sourceChannel.isOpen())
                sourceChannel.close();
            if (destinationChannel != null && destinationChannel.isOpen())
                destinationChannel.close();
        }
    }
}
