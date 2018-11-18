package org.ontology.tcc.entities.impl;

import org.ontology.tcc.entities.*;


import java.net.URI;
import java.util.Collection;
import javax.xml.datatype.XMLGregorianCalendar;

import org.protege.owl.codegeneration.WrappedIndividual;
import org.protege.owl.codegeneration.impl.WrappedIndividualImpl;

import org.protege.owl.codegeneration.inference.CodeGenerationInference;

import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLOntology;


/**
 * Generated by Protege (http://protege.stanford.edu).<br>
 * Source Class: DefaultSubclasse <br>
 * @version generated on Sat Sep 15 16:28:35 BRT 2018 by Julia
 */
public class DefaultSubclasse extends WrappedIndividualImpl implements Subclasse {

    public DefaultSubclasse(CodeGenerationInference inference, IRI iri) {
        super(inference, iri);
    }





    /* ***************************************************
     * Object Property http://www.semanticweb.org/gabriel/ontologies/2017/8/mei#permite
     */
     
    public Collection<? extends Atividade> getPermite() {
        return getDelegate().getPropertyValues(getOwlIndividual(),
                                               Vocabulary.OBJECT_PROPERTY_PERMITE,
                                               DefaultAtividade.class);
    }

    public boolean hasPermite() {
	   return !getPermite().isEmpty();
    }

    public void addPermite(Atividade newPermite) {
        getDelegate().addPropertyValue(getOwlIndividual(),
                                       Vocabulary.OBJECT_PROPERTY_PERMITE,
                                       newPermite);
    }

    public void removePermite(Atividade oldPermite) {
        getDelegate().removePropertyValue(getOwlIndividual(),
                                          Vocabulary.OBJECT_PROPERTY_PERMITE,
                                          oldPermite);
    }


    /* ***************************************************
     * Object Property http://www.semanticweb.org/gabriel/ontologies/2017/8/mei#temGrupo
     */
     
    public Collection<? extends ConjuntoCNAE> getTemGrupo() {
        return getDelegate().getPropertyValues(getOwlIndividual(),
                                               Vocabulary.OBJECT_PROPERTY_TEMGRUPO,
                                               DefaultConjuntoCNAE.class);
    }

    public boolean hasTemGrupo() {
	   return !getTemGrupo().isEmpty();
    }

    public void addTemGrupo(ConjuntoCNAE newTemGrupo) {
        getDelegate().addPropertyValue(getOwlIndividual(),
                                       Vocabulary.OBJECT_PROPERTY_TEMGRUPO,
                                       newTemGrupo);
    }

    public void removeTemGrupo(ConjuntoCNAE oldTemGrupo) {
        getDelegate().removePropertyValue(getOwlIndividual(),
                                          Vocabulary.OBJECT_PROPERTY_TEMGRUPO,
                                          oldTemGrupo);
    }


    /* ***************************************************
     * Object Property http://www.semanticweb.org/gabriel/ontologies/2017/8/mei#temSubGrupo
     */
     
    public Collection<? extends ConjuntoCNAE> getTemSubGrupo() {
        return getDelegate().getPropertyValues(getOwlIndividual(),
                                               Vocabulary.OBJECT_PROPERTY_TEMSUBGRUPO,
                                               DefaultConjuntoCNAE.class);
    }

    public boolean hasTemSubGrupo() {
	   return !getTemSubGrupo().isEmpty();
    }

    public void addTemSubGrupo(ConjuntoCNAE newTemSubGrupo) {
        getDelegate().addPropertyValue(getOwlIndividual(),
                                       Vocabulary.OBJECT_PROPERTY_TEMSUBGRUPO,
                                       newTemSubGrupo);
    }

    public void removeTemSubGrupo(ConjuntoCNAE oldTemSubGrupo) {
        getDelegate().removePropertyValue(getOwlIndividual(),
                                          Vocabulary.OBJECT_PROPERTY_TEMSUBGRUPO,
                                          oldTemSubGrupo);
    }


    /* ***************************************************
     * Data Property http://www.semanticweb.org/gabriel/ontologies/2017/8/mei#conjuntoCodigo
     */
     
    public Collection<? extends String> getConjuntoCodigo() {
		return getDelegate().getPropertyValues(getOwlIndividual(), Vocabulary.DATA_PROPERTY_CONJUNTOCODIGO, String.class);
    }

    public boolean hasConjuntoCodigo() {
		return !getConjuntoCodigo().isEmpty();
    }

    public void addConjuntoCodigo(String newConjuntoCodigo) {
	    getDelegate().addPropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_CONJUNTOCODIGO, newConjuntoCodigo);
    }

    public void removeConjuntoCodigo(String oldConjuntoCodigo) {
		getDelegate().removePropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_CONJUNTOCODIGO, oldConjuntoCodigo);
    }


    /* ***************************************************
     * Data Property http://www.semanticweb.org/gabriel/ontologies/2017/8/mei#conjuntoDescricao
     */
     
    public Collection<? extends String> getConjuntoDescricao() {
		return getDelegate().getPropertyValues(getOwlIndividual(), Vocabulary.DATA_PROPERTY_CONJUNTODESCRICAO, String.class);
    }

    public boolean hasConjuntoDescricao() {
		return !getConjuntoDescricao().isEmpty();
    }

    public void addConjuntoDescricao(String newConjuntoDescricao) {
	    getDelegate().addPropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_CONJUNTODESCRICAO, newConjuntoDescricao);
    }

    public void removeConjuntoDescricao(String oldConjuntoDescricao) {
		getDelegate().removePropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_CONJUNTODESCRICAO, oldConjuntoDescricao);
    }


}
