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
@Name(value = "card")
@Table(name = "20_card")
public class Card implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_credito_card_20")
	private Long cardId;		// PK counter
		
	@Column(name = "num_card_20")
	private int numCard;
	
	@ManyToOne
	@JoinColumn(name = "tipologia_card_20")
	private TipologiaCard tipologiaCard;
	
	@Column(name = "fl_usata_20")
	private String flusata;
	
	
	
	public Card() {
	}

	
	
	
	
	
public Long getCardId() {
		return cardId;
	}






	public void setCardId(Long cardId) {
		this.cardId = cardId;
	}






	public int getNumCard() {
		return numCard;
	}






	public void setNumCard(int numCard) {
		this.numCard = numCard;
	}






	public TipologiaCard getTipologiaCard() {
		return tipologiaCard;
	}






	public void setTipologiaCard(TipologiaCard tipologiaCard) {
		this.tipologiaCard = tipologiaCard;
	}






	public String getFlusata() {
		return flusata;
	}






	public void setFlusata(String flusata) {
		this.flusata = flusata;
	}






@Override
    public boolean equals(Object other) {
        if (other == null || !(other instanceof Card)) {
            return false;
        }
        Card otherCard = (Card) other;
        return (getCardId() == otherCard.getCardId());
    }

    @Override
    public int hashCode() {
        int intId = (int)(getCardId()/1000);
    	return 37*intId + 97;
    }
}
