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
 * Source Class: AtividadeProduto <br>
 * @version generated on Sat Sep 15 16:28:33 BRT 2018 by Julia
 */

public interface AtividadeProduto extends AtividadeElemento {

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
     * Property http://www.semanticweb.org/gabriel/ontologies/2017/8/mei#especificoParaProduto
     */
     
    /**
     * Gets all property values for the especificoParaProduto property.<p>
     * 
     * @returns a collection of values for the especificoParaProduto property.
     */
    Collection<? extends AtividadeProduto> getEspecificoParaProduto();

    /**
     * Checks if the class has a especificoParaProduto property value.<p>
     * 
     * @return true if there is a especificoParaProduto property value.
     */
    boolean hasEspecificoParaProduto();

    /**
     * Adds a especificoParaProduto property value.<p>
     * 
     * @param newEspecificoParaProduto the especificoParaProduto property value to be added
     */
    void addEspecificoParaProduto(AtividadeProduto newEspecificoParaProduto);

    /**
     * Removes a especificoParaProduto property value.<p>
     * 
     * @param oldEspecificoParaProduto the especificoParaProduto property value to be removed.
     */
    void removeEspecificoParaProduto(AtividadeProduto oldEspecificoParaProduto);


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
     * Property http://www.semanticweb.org/gabriel/ontologies/2017/8/mei#genericoParaProduto
     */
     
    /**
     * Gets all property values for the genericoParaProduto property.<p>
     * 
     * @returns a collection of values for the genericoParaProduto property.
     */
    Collection<? extends AtividadeProduto> getGenericoParaProduto();

    /**
     * Checks if the class has a genericoParaProduto property value.<p>
     * 
     * @return true if there is a genericoParaProduto property value.
     */
    boolean hasGenericoParaProduto();

    /**
     * Adds a genericoParaProduto property value.<p>
     * 
     * @param newGenericoParaProduto the genericoParaProduto property value to be added
     */
    void addGenericoParaProduto(AtividadeProduto newGenericoParaProduto);

    /**
     * Removes a genericoParaProduto property value.<p>
     * 
     * @param oldGenericoParaProduto the genericoParaProduto property value to be removed.
     */
    void removeGenericoParaProduto(AtividadeProduto oldGenericoParaProduto);


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
     * Property http://www.semanticweb.org/gabriel/ontologies/2017/8/mei#satisfazCondicaoProduto
     */
     
    /**
     * Gets all property values for the satisfazCondicaoProduto property.<p>
     * 
     * @returns a collection of values for the satisfazCondicaoProduto property.
     */
    Collection<? extends AtividadeCondicaoProduto> getSatisfazCondicaoProduto();

    /**
     * Checks if the class has a satisfazCondicaoProduto property value.<p>
     * 
     * @return true if there is a satisfazCondicaoProduto property value.
     */
    boolean hasSatisfazCondicaoProduto();

    /**
     * Adds a satisfazCondicaoProduto property value.<p>
     * 
     * @param newSatisfazCondicaoProduto the satisfazCondicaoProduto property value to be added
     */
    void addSatisfazCondicaoProduto(AtividadeCondicaoProduto newSatisfazCondicaoProduto);

    /**
     * Removes a satisfazCondicaoProduto property value.<p>
     * 
     * @param oldSatisfazCondicaoProduto the satisfazCondicaoProduto property value to be removed.
     */
    void removeSatisfazCondicaoProduto(AtividadeCondicaoProduto oldSatisfazCondicaoProduto);


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
