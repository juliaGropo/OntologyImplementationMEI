package org.ontology.tcc.entities;

import java.net.URI;
import java.util.Collection;
import javax.xml.datatype.XMLGregorianCalendar;

import org.protege.owl.codegeneration.WrappedIndividual;

import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLOntology;

/**
 * 
 * <p>
 * Generated by Protege (http://protege.stanford.edu). <br>
 * Source Class: AtividadeLocal <br>
 * @version generated on Sat Sep 15 16:28:32 BRT 2018 by Julia
 */

public interface AtividadeLocal extends AtividadeElemento {

    /* ***************************************************
     * Property http://www.semanticweb.org/gabriel/ontologies/2017/8/mei#elementoTidoPor
     */
     
    /**
     * Gets all property values for the elementoTidoPor property.<p>
     * 
     * @returns a collection of values for the elementoTidoPor property.
     */
    Collection<? extends WrappedIndividual> getElementoTidoPor();

    /**
     * Checks if the class has a elementoTidoPor property value.<p>
     * 
     * @return true if there is a elementoTidoPor property value.
     */
    boolean hasElementoTidoPor();

    /**
     * Adds a elementoTidoPor property value.<p>
     * 
     * @param newElementoTidoPor the elementoTidoPor property value to be added
     */
    void addElementoTidoPor(WrappedIndividual newElementoTidoPor);

    /**
     * Removes a elementoTidoPor property value.<p>
     * 
     * @param oldElementoTidoPor the elementoTidoPor property value to be removed.
     */
    void removeElementoTidoPor(WrappedIndividual oldElementoTidoPor);


    /* ***************************************************
     * Property http://www.semanticweb.org/gabriel/ontologies/2017/8/mei#especificoPara
     */
     
    /**
     * Gets all property values for the especificoPara property.<p>
     * 
     * @returns a collection of values for the especificoPara property.
     */
    Collection<? extends AtividadeElemento> getEspecificoPara();

    /**
     * Checks if the class has a especificoPara property value.<p>
     * 
     * @return true if there is a especificoPara property value.
     */
    boolean hasEspecificoPara();

    /**
     * Adds a especificoPara property value.<p>
     * 
     * @param newEspecificoPara the especificoPara property value to be added
     */
    void addEspecificoPara(AtividadeElemento newEspecificoPara);

    /**
     * Removes a especificoPara property value.<p>
     * 
     * @param oldEspecificoPara the especificoPara property value to be removed.
     */
    void removeEspecificoPara(AtividadeElemento oldEspecificoPara);


    /* ***************************************************
     * Property http://www.semanticweb.org/gabriel/ontologies/2017/8/mei#genericoPara
     */
     
    /**
     * Gets all property values for the genericoPara property.<p>
     * 
     * @returns a collection of values for the genericoPara property.
     */
    Collection<? extends AtividadeElemento> getGenericoPara();

    /**
     * Checks if the class has a genericoPara property value.<p>
     * 
     * @return true if there is a genericoPara property value.
     */
    boolean hasGenericoPara();

    /**
     * Adds a genericoPara property value.<p>
     * 
     * @param newGenericoPara the genericoPara property value to be added
     */
    void addGenericoPara(AtividadeElemento newGenericoPara);

    /**
     * Removes a genericoPara property value.<p>
     * 
     * @param oldGenericoPara the genericoPara property value to be removed.
     */
    void removeGenericoPara(AtividadeElemento oldGenericoPara);


    /* ***************************************************
     * Property http://www.semanticweb.org/gabriel/ontologies/2017/8/mei#satisfazCondicao
     */
     
    /**
     * Gets all property values for the satisfazCondicao property.<p>
     * 
     * @returns a collection of values for the satisfazCondicao property.
     */
    Collection<? extends AtividadeCondicao> getSatisfazCondicao();

    /**
     * Checks if the class has a satisfazCondicao property value.<p>
     * 
     * @return true if there is a satisfazCondicao property value.
     */
    boolean hasSatisfazCondicao();

    /**
     * Adds a satisfazCondicao property value.<p>
     * 
     * @param newSatisfazCondicao the satisfazCondicao property value to be added
     */
    void addSatisfazCondicao(AtividadeCondicao newSatisfazCondicao);

    /**
     * Removes a satisfazCondicao property value.<p>
     * 
     * @param oldSatisfazCondicao the satisfazCondicao property value to be removed.
     */
    void removeSatisfazCondicao(AtividadeCondicao oldSatisfazCondicao);


    /* ***************************************************
     * Property http://www.semanticweb.org/gabriel/ontologies/2017/8/mei#satisfazCondicaoLocal
     */
     
    /**
     * Gets all property values for the satisfazCondicaoLocal property.<p>
     * 
     * @returns a collection of values for the satisfazCondicaoLocal property.
     */
    Collection<? extends AtividadeCondicaoLocal> getSatisfazCondicaoLocal();

    /**
     * Checks if the class has a satisfazCondicaoLocal property value.<p>
     * 
     * @return true if there is a satisfazCondicaoLocal property value.
     */
    boolean hasSatisfazCondicaoLocal();

    /**
     * Adds a satisfazCondicaoLocal property value.<p>
     * 
     * @param newSatisfazCondicaoLocal the satisfazCondicaoLocal property value to be added
     */
    void addSatisfazCondicaoLocal(AtividadeCondicaoLocal newSatisfazCondicaoLocal);

    /**
     * Removes a satisfazCondicaoLocal property value.<p>
     * 
     * @param oldSatisfazCondicaoLocal the satisfazCondicaoLocal property value to be removed.
     */
    void removeSatisfazCondicaoLocal(AtividadeCondicaoLocal oldSatisfazCondicaoLocal);


    /* ***************************************************
     * Property http://www.semanticweb.org/gabriel/ontologies/2017/8/mei#atividadeElementoDescricao
     */
     
    /**
     * Gets all property values for the atividadeElementoDescricao property.<p>
     * 
     * @returns a collection of values for the atividadeElementoDescricao property.
     */
    Collection<? extends String> getAtividadeElementoDescricao();

    /**
     * Checks if the class has a atividadeElementoDescricao property value.<p>
     * 
     * @return true if there is a atividadeElementoDescricao property value.
     */
    boolean hasAtividadeElementoDescricao();

    /**
     * Adds a atividadeElementoDescricao property value.<p>
     * 
     * @param newAtividadeElementoDescricao the atividadeElementoDescricao property value to be added
     */
    void addAtividadeElementoDescricao(String newAtividadeElementoDescricao);

    /**
     * Removes a atividadeElementoDescricao property value.<p>
     * 
     * @param oldAtividadeElementoDescricao the atividadeElementoDescricao property value to be removed.
     */
    void removeAtividadeElementoDescricao(String oldAtividadeElementoDescricao);



    /* ***************************************************
     * Common interfaces
     */

    OWLNamedIndividual getOwlIndividual();

    OWLOntology getOwlOntology();

    void delete();

}
