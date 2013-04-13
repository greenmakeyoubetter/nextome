package com.mydomain.pkg.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.jboss.seam.annotations.Name;

import javax.persistence.Column;
import javax.persistence.Table;

@Entity
@Name(value = "feedbackCondivisione")
@Table(name = "17_feedback_condivisione")
public class FeedbackCondivisione implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_feedback_condivisione_17")
	private Long feedbackId;		// PK counter
		
	@ManyToOne
	@JoinColumn(name = "richiesta_condivisione_17")
	private RichiestaCondivisione richiestaCondivisione;
	
	@Column(name = "voto_richiedente_17")
	private int votoRichiedente;
	
	@Column(name = "commento_richiedente_17")
	private String commentoRichiedente;
	
	@Column(name = "voto_condividente_17")
	private int votoCondividente;
	
	@Column(name = "commento_condividente_17")
	private String commentoCondividente;
	
	public FeedbackCondivisione() {
	}
	





public Long getFeedbackId() {
		return feedbackId;
	}






	public void setFeedbackId(Long feedbackId) {
		this.feedbackId = feedbackId;
	}






	public RichiestaCondivisione getRichiestaCondivisione() {
		return richiestaCondivisione;
	}






	public void setRichiestaCondivisione(RichiestaCondivisione richiestaCondivisione) {
		this.richiestaCondivisione = richiestaCondivisione;
	}






	public int getVotoRichiedente() {
		return votoRichiedente;
	}






	public void setVotoRichiedente(int votoRichiedente) {
		this.votoRichiedente = votoRichiedente;
	}






	public String getCommentoRichiedente() {
		return commentoRichiedente;
	}






	public void setCommentoRichiedente(String commentoRichiedente) {
		this.commentoRichiedente = commentoRichiedente;
	}






	public int getVotoCondividente() {
		return votoCondividente;
	}






	public void setVotoCondividente(int votoCondividente) {
		this.votoCondividente = votoCondividente;
	}






	public String getCommentoCondividente() {
		return commentoCondividente;
	}






	public void setCommentoCondividente(String commentoCondividente) {
		this.commentoCondividente = commentoCondividente;
	}






@Override
    public boolean equals(Object other) {
        if (other == null || !(other instanceof FeedbackCondivisione)) {
            return false;
        }
        FeedbackCondivisione otherFeedbackCondivisione = (FeedbackCondivisione) other;
        return (getFeedbackId() == otherFeedbackCondivisione.getFeedbackId());
    }

    @Override
    public int hashCode() {
        int intId = (int)(getFeedbackId()/1000);
    	return 37*intId + 97;
    }
}
