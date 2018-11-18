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
 * Source Class: DefaultAtividadeRequisitoServicoVariavel <br>
 * @version generated on Sat Sep 15 16:28:34 BRT 2018 by Julia
 */
public class DefaultAtividadeRequisitoServicoVariavel extends WrappedIndividualImpl implements AtividadeRequisitoServicoVariavel {

    public DefaultAtividadeRequisitoServicoVariavel(CodeGenerationInference inference, IRI iri) {
        super(inference, iri);
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
     * Object Property http://www.semanticweb.org/gabriel/ontologies/2017/8/mei#requisitoSatisfeitoPor
     */
     
    public Collection<? extends WrappedIndividual> getRequisitoSatisfeitoPor() {
        return getDelegate().getPropertyValues(getOwlIndividual(),
                                               Vocabulary.OBJECT_PROPERTY_REQUISITOSATISFEITOPOR,
                                               WrappedIndividualImpl.class);
    }

    public boolean hasRequisitoSatisfeitoPor() {
	   return !getRequisitoSatisfeitoPor().isEmpty();
    }

    public void addRequisitoSatisfeitoPor(WrappedIndividual newRequisitoSatisfeitoPor) {
        getDelegate().addPropertyValue(getOwlIndividual(),
                                       Vocabulary.OBJECT_PROPERTY_REQUISITOSATISFEITOPOR,
                                       newRequisitoSatisfeitoPor);
    }

    public void removeRequisitoSatisfeitoPor(WrappedIndividual oldRequisitoSatisfeitoPor) {
        getDelegate().removePropertyValue(getOwlIndividual(),
                                          Vocabulary.OBJECT_PROPERTY_REQUISITOSATISFEITOPOR,
                                          oldRequisitoSatisfeitoPor);
    }


    /* ***************************************************
     * Object Property http://www.semanticweb.org/gabriel/ontologies/2017/8/mei#requisitoServicoVariavelTidoPor
     */
     
    public Collection<? extends AtividadeCondicaoServico> getRequisitoServicoVariavelTidoPor() {
        return getDelegate().getPropertyValues(getOwlIndividual(),
                                               Vocabulary.OBJECT_PROPERTY_REQUISITOSERVICOVARIAVELTIDOPOR,
                                               DefaultAtividadeCondicaoServico.class);
    }

    public boolean hasRequisitoServicoVariavelTidoPor() {
	   return !getRequisitoServicoVariavelTidoPor().isEmpty();
    }

    public void addRequisitoServicoVariavelTidoPor(AtividadeCondicaoServico newRequisitoServicoVariavelTidoPor) {
        getDelegate().addPropertyValue(getOwlIndividual(),
                                       Vocabulary.OBJECT_PROPERTY_REQUISITOSERVICOVARIAVELTIDOPOR,
                                       newRequisitoServicoVariavelTidoPor);
    }

    public void removeRequisitoServicoVariavelTidoPor(AtividadeCondicaoServico oldRequisitoServicoVariavelTidoPor) {
        getDelegate().removePropertyValue(getOwlIndividual(),
                                          Vocabulary.OBJECT_PROPERTY_REQUISITOSERVICOVARIAVELTIDOPOR,
                                          oldRequisitoServicoVariavelTidoPor);
    }


    /* ***************************************************
     * Object Property http://www.semanticweb.org/gabriel/ontologies/2017/8/mei#requisitoTidoPor
     */
     
    public Collection<? extends AtividadeCondicao> getRequisitoTidoPor() {
        return getDelegate().getPropertyValues(getOwlIndividual(),
                                               Vocabulary.OBJECT_PROPERTY_REQUISITOTIDOPOR,
                                               DefaultAtividadeCondicao.class);
    }

    public boolean hasRequisitoTidoPor() {
	   return !getRequisitoTidoPor().isEmpty();
    }

    public void addRequisitoTidoPor(AtividadeCondicao newRequisitoTidoPor) {
        getDelegate().addPropertyValue(getOwlIndividual(),
                                       Vocabulary.OBJECT_PROPERTY_REQUISITOTIDOPOR,
                                       newRequisitoTidoPor);
    }

    public void removeRequisitoTidoPor(AtividadeCondicao oldRequisitoTidoPor) {
        getDelegate().removePropertyValue(getOwlIndividual(),
                                          Vocabulary.OBJECT_PROPERTY_REQUISITOTIDOPOR,
                                          oldRequisitoTidoPor);
    }


    /* ***************************************************
     * Object Property http://www.semanticweb.org/gabriel/ontologies/2017/8/mei#requisitoVariavelTidoPor
     */
     
    public Collection<? extends AtividadeCondicao> getRequisitoVariavelTidoPor() {
        return getDelegate().getPropertyValues(getOwlIndividual(),
                                               Vocabulary.OBJECT_PROPERTY_REQUISITOVARIAVELTIDOPOR,
                                               DefaultAtividadeCondicao.class);
    }

    public boolean hasRequisitoVariavelTidoPor() {
	   return !getRequisitoVariavelTidoPor().isEmpty();
    }

    public void addRequisitoVariavelTidoPor(AtividadeCondicao newRequisitoVariavelTidoPor) {
        getDelegate().addPropertyValue(getOwlIndividual(),
                                       Vocabulary.OBJECT_PROPERTY_REQUISITOVARIAVELTIDOPOR,
                                       newRequisitoVariavelTidoPor);
    }

    public void removeRequisitoVariavelTidoPor(AtividadeCondicao oldRequisitoVariavelTidoPor) {
        getDelegate().removePropertyValue(getOwlIndividual(),
                                          Vocabulary.OBJECT_PROPERTY_REQUISITOVARIAVELTIDOPOR,
                                          oldRequisitoVariavelTidoPor);
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