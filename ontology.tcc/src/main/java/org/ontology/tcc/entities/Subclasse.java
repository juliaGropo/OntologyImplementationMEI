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
 * Source Class: Subclasse <br>
 * @version generated on Sat Sep 15 16:28:35 BRT 2018 by Julia
 */

public interface Subclasse extends ConjuntoCNAE {

    /* ***************************************************
     * Property http://www.semanticweb.org/gabriel/ontologies/2017/8/mei#permite
     */
     
    /**
     * Gets all property values for the permite property.<p>
     * 
     * @returns a collection of values for the permite property.
     */
    Collection<? extends Atividade> getPermite();

    /**
     * Checks if the class has a permite property value.<p>
     * 
     * @return true if there is a permite property value.
     */
    boolean hasPermite();

    /**
     * Adds a permite property value.<p>
     * 
     * @param newPermite the permite property value to be added
     */
    void addPermite(Atividade newPermite);

    /**
     * Removes a permite property value.<p>
     * 
     * @param oldPermite the permite property value to be removed.
     */
    void removePermite(Atividade oldPermite);


    /* ***************************************************
     * Property http://www.semanticweb.org/gabriel/ontologies/2017/8/mei#temGrupo
     */
     
    /**
     * Gets all property values for the temGrupo property.<p>
     * 
     * @returns a collection of values for the temGrupo property.
     */
    Collection<? extends ConjuntoCNAE> getTemGrupo();

    /**
     * Checks if the class has a temGrupo property value.<p>
     * 
     * @return true if there is a temGrupo property value.
     */
    boolean hasTemGrupo();

    /**
     * Adds a temGrupo property value.<p>
     * 
     * @param newTemGrupo the temGrupo property value to be added
     */
    void addTemGrupo(ConjuntoCNAE newTemGrupo);

    /**
     * Removes a temGrupo property value.<p>
     * 
     * @param oldTemGrupo the temGrupo property value to be removed.
     */
    void removeTemGrupo(ConjuntoCNAE oldTemGrupo);


    /* ***************************************************
     * Property http://www.semanticweb.org/gabriel/ontologies/2017/8/mei#temSubGrupo
     */
     
    /**
     * Gets all property values for the temSubGrupo property.<p>
     * 
     * @returns a collection of values for the temSubGrupo property.
     */
    Collection<? extends ConjuntoCNAE> getTemSubGrupo();

    /**
     * Checks if the class has a temSubGrupo property value.<p>
     * 
     * @return true if there is a temSubGrupo property value.
     */
    boolean hasTemSubGrupo();

    /**
     * Adds a temSubGrupo property value.<p>
     * 
     * @param newTemSubGrupo the temSubGrupo property value to be added
     */
    void addTemSubGrupo(ConjuntoCNAE newTemSubGrupo);

    /**
     * Removes a temSubGrupo property value.<p>
     * 
     * @param oldTemSubGrupo the temSubGrupo property value to be removed.
     */
    void removeTemSubGrupo(ConjuntoCNAE oldTemSubGrupo);


    /* ***************************************************
     * Property http://www.semanticweb.org/gabriel/ontologies/2017/8/mei#conjuntoCodigo
     */
     
    /**
     * Gets all property values for the conjuntoCodigo property.<p>
     * 
     * @returns a collection of values for the conjuntoCodigo property.
     */
    Collection<? extends String> getConjuntoCodigo();

    /**
     * Checks if the class has a conjuntoCodigo property value.<p>
     * 
     * @return true if there is a conjuntoCodigo property value.
     */
    boolean hasConjuntoCodigo();

    /**
     * Adds a conjuntoCodigo property value.<p>
     * 
     * @param newConjuntoCodigo the conjuntoCodigo property value to be added
     */
    void addConjuntoCodigo(String newConjuntoCodigo);

    /**
     * Removes a conjuntoCodigo property value.<p>
     * 
     * @param oldConjuntoCodigo the conjuntoCodigo property value to be removed.
     */
    void removeConjuntoCodigo(String oldConjuntoCodigo);



    /* ***************************************************
     * Property http://www.semanticweb.org/gabriel/ontologies/2017/8/mei#conjuntoDescricao
     */
     
    /**
     * Gets all property values for the conjuntoDescricao property.<p>
     * 
     * @returns a collection of values for the conjuntoDescricao property.
     */
    Collection<? extends String> getConjuntoDescricao();

    /**
     * Checks if the class has a conjuntoDescricao property value.<p>
     * 
     * @return true if there is a conjuntoDescricao property value.
     */
    boolean hasConjuntoDescricao();

    /**
     * Adds a conjuntoDescricao property value.<p>
     * 
     * @param newConjuntoDescricao the conjuntoDescricao property value to be added
     */
    void addConjuntoDescricao(String newConjuntoDescricao);

    /**
     * Removes a conjuntoDescricao property value.<p>
     * 
     * @param oldConjuntoDescricao the conjuntoDescricao property value to be removed.
     */
    void removeConjuntoDescricao(String oldConjuntoDescricao);



    /* ***************************************************
     * Common interfaces
     */

    OWLNamedIndividual getOwlIndividual();

    OWLOntology getOwlOntology();

    void delete();

}
