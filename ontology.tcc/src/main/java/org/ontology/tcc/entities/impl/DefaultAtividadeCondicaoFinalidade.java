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
 * Source Class: DefaultAtividadeCondicaoFinalidade <br>
 * @version generated on Sat Sep 15 16:28:32 BRT 2018 by Julia
 */
public class DefaultAtividadeCondicaoFinalidade extends WrappedIndividualImpl implements AtividadeCondicaoFinalidade {

    public DefaultAtividadeCondicaoFinalidade(CodeGenerationInference inference, IRI iri) {
        super(inference, iri);
    }





    /* ***************************************************
     * Object Property http://www.semanticweb.org/gabriel/ontologies/2017/8/mei#condicaoFinalidadeSatisfeitaPor
     */
     
    public Collection<? extends AtividadeFinalidade> getCondicaoFinalidadeSatisfeitaPor() {
        return getDelegate().getPropertyValues(getOwlIndividual(),
                                               Vocabulary.OBJECT_PROPERTY_CONDICAOFINALIDADESATISFEITAPOR,
                                               DefaultAtividadeFinalidade.class);
    }

    public boolean hasCondicaoFinalidadeSatisfeitaPor() {
	   return !getCondicaoFinalidadeSatisfeitaPor().isEmpty();
    }

    public void addCondicaoFinalidadeSatisfeitaPor(AtividadeFinalidade newCondicaoFinalidadeSatisfeitaPor) {
        getDelegate().addPropertyValue(getOwlIndividual(),
                                       Vocabulary.OBJECT_PROPERTY_CONDICAOFINALIDADESATISFEITAPOR,
                                       newCondicaoFinalidadeSatisfeitaPor);
    }

    public void removeCondicaoFinalidadeSatisfeitaPor(AtividadeFinalidade oldCondicaoFinalidadeSatisfeitaPor) {
        getDelegate().removePropertyValue(getOwlIndividual(),
                                          Vocabulary.OBJECT_PROPERTY_CONDICAOFINALIDADESATISFEITAPOR,
                                          oldCondicaoFinalidadeSatisfeitaPor);
    }


    /* ***************************************************
     * Object Property http://www.semanticweb.org/gabriel/ontologies/2017/8/mei#condicaoSatisfeitaPor
     */
     
    public Collection<? extends AtividadeElemento> getCondicaoSatisfeitaPor() {
        return getDelegate().getPropertyValues(getOwlIndividual(),
                                               Vocabulary.OBJECT_PROPERTY_CONDICAOSATISFEITAPOR,
                                               DefaultAtividadeElemento.class);
    }

    public boolean hasCondicaoSatisfeitaPor() {
	   return !getCondicaoSatisfeitaPor().isEmpty();
    }

    public void addCondicaoSatisfeitaPor(AtividadeElemento newCondicaoSatisfeitaPor) {
        getDelegate().addPropertyValue(getOwlIndividual(),
                                       Vocabulary.OBJECT_PROPERTY_CONDICAOSATISFEITAPOR,
                                       newCondicaoSatisfeitaPor);
    }

    public void removeCondicaoSatisfeitaPor(AtividadeElemento oldCondicaoSatisfeitaPor) {
        getDelegate().removePropertyValue(getOwlIndividual(),
                                          Vocabulary.OBJECT_PROPERTY_CONDICAOSATISFEITAPOR,
                                          oldCondicaoSatisfeitaPor);
    }


    /* ***************************************************
     * Object Property http://www.semanticweb.org/gabriel/ontologies/2017/8/mei#elementoTidoPor
     */
     
    public Collection<? extends WrappedIndividual> getElementoTidoPor() {
        return getDelegate().getPropertyValues(getOwlIndividual(),
                                               Vocabulary.OBJECT_PROPERTY_ELEMENTOTIDOPOR,
                                               WrappedIndividualImpl.class);
    }

    public boolean hasElementoTidoPor() {
	   return !getElementoTidoPor().isEmpty();
    }

    public void addElementoTidoPor(WrappedIndividual newElementoTidoPor) {
        getDelegate().addPropertyValue(getOwlIndividual(),
                                       Vocabulary.OBJECT_PROPERTY_ELEMENTOTIDOPOR,
                                       newElementoTidoPor);
    }

    public void removeElementoTidoPor(WrappedIndividual oldElementoTidoPor) {
        getDelegate().removePropertyValue(getOwlIndividual(),
                                          Vocabulary.OBJECT_PROPERTY_ELEMENTOTIDOPOR,
                                          oldElementoTidoPor);
    }


    /* ***************************************************
     * Object Property http://www.semanticweb.org/gabriel/ontologies/2017/8/mei#especificoPara
     */
     
    public Collection<? extends AtividadeElemento> getEspecificoPara() {
        return getDelegate().getPropertyValues(getOwlIndividual(),
                                               Vocabulary.OBJECT_PROPERTY_ESPECIFICOPARA,
                                               DefaultAtividadeElemento.class);
    }

    public boolean hasEspecificoPara() {
	   return !getEspecificoPara().isEmpty();
    }

    public void addEspecificoPara(AtividadeElemento newEspecificoPara) {
        getDelegate().addPropertyValue(getOwlIndividual(),
                                       Vocabulary.OBJECT_PROPERTY_ESPECIFICOPARA,
                                       newEspecificoPara);
    }

    public void removeEspecificoPara(AtividadeElemento oldEspecificoPara) {
        getDelegate().removePropertyValue(getOwlIndividual(),
                                          Vocabulary.OBJECT_PROPERTY_ESPECIFICOPARA,
                                          oldEspecificoPara);
    }


    /* ***************************************************
     * Object Property http://www.semanticweb.org/gabriel/ontologies/2017/8/mei#genericoPara
     */
     
    public Collection<? extends AtividadeElemento> getGenericoPara() {
        return getDelegate().getPropertyValues(getOwlIndividual(),
                                               Vocabulary.OBJECT_PROPERTY_GENERICOPARA,
                                               DefaultAtividadeElemento.class);
    }

    public boolean hasGenericoPara() {
	   return !getGenericoPara().isEmpty();
    }

    public void addGenericoPara(AtividadeElemento newGenericoPara) {
        getDelegate().addPropertyValue(getOwlIndividual(),
                                       Vocabulary.OBJECT_PROPERTY_GENERICOPARA,
                                       newGenericoPara);
    }

    public void removeGenericoPara(AtividadeElemento oldGenericoPara) {
        getDelegate().removePropertyValue(getOwlIndividual(),
                                          Vocabulary.OBJECT_PROPERTY_GENERICOPARA,
                                          oldGenericoPara);
    }


    /* ***************************************************
     * Object Property http://www.semanticweb.org/gabriel/ontologies/2017/8/mei#satisfazCondicao
     */
     
    public Collection<? extends AtividadeCondicao> getSatisfazCondicao() {
        return getDelegate().getPropertyValues(getOwlIndividual(),
                                               Vocabulary.OBJECT_PROPERTY_SATISFAZCONDICAO,
                                               DefaultAtividadeCondicao.class);
    }

    public boolean hasSatisfazCondicao() {
	   return !getSatisfazCondicao().isEmpty();
    }

    public void addSatisfazCondicao(AtividadeCondicao newSatisfazCondicao) {
        getDelegate().addPropertyValue(getOwlIndividual(),
                                       Vocabulary.OBJECT_PROPERTY_SATISFAZCONDICAO,
                                       newSatisfazCondicao);
    }

    public void removeSatisfazCondicao(AtividadeCondicao oldSatisfazCondicao) {
        getDelegate().removePropertyValue(getOwlIndividual(),
                                          Vocabulary.OBJECT_PROPERTY_SATISFAZCONDICAO,
                                          oldSatisfazCondicao);
    }


    /* ***************************************************
     * Data Property http://www.semanticweb.org/gabriel/ontologies/2017/8/mei#atividadeElementoDescricao
     */
     
    public Collection<? extends String> getAtividadeElementoDescricao() {
		return getDelegate().getPropertyValues(getOwlIndividual(), Vocabulary.DATA_PROPERTY_ATIVIDADEELEMENTODESCRICAO, String.class);
    }

    public boolean hasAtividadeElementoDescricao() {
		return !getAtividadeElementoDescricao().isEmpty();
    }

    public void addAtividadeElementoDescricao(String newAtividadeElementoDescricao) {
	    getDelegate().addPropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_ATIVIDADEELEMENTODESCRICAO, newAtividadeElementoDescricao);
    }

    public void removeAtividadeElementoDescricao(String oldAtividadeElementoDescricao) {
		getDelegate().removePropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_ATIVIDADEELEMENTODESCRICAO, oldAtividadeElementoDescricao);
    }


}
