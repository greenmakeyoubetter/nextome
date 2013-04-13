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
@Name(value = "tipologiaCard")
@Table(name = "21_tipologia_card")
public class TipologiaCard implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tipologia_card_21")
	private Long tipologiaCardId;		// PK counter
		
	@Column(name = "tipo_card_21")
	private String tipoCard;
	
	@Column(name = "prezzo_card_21")
	private Double prezzoCard;
	
	@Column(name = "fl_disponibilita_21")
	private String flDisponibilitaCard;
	
	
	
	public TipologiaCard() {
	}
	

public Long getTipologiaCardId() {
		return tipologiaCardId;
	}


	public void setTipologiaCardId(Long tipologiaCardId) {
		this.tipologiaCardId = tipologiaCardId;
	}


	public String getTipoCard() {
		return tipoCard;
	}


	public void setTipoCard(String tipoCard) {
		this.tipoCard = tipoCard;
	}


	public Double getPrezzoCard() {
		return prezzoCard;
	}

public void setPrezzoCard(Double prezzoCard) {
		this.prezzoCard = prezzoCard;
	}



	public String getFlDisponibilitaCard() {
		return flDisponibilitaCard;
	}

public void setFlDisponibilitaCard(String flDisponibilitaCard) {
		this.flDisponibilitaCard = flDisponibilitaCard;
	}


@Override
    public boolean equals(Object other) {
        if (other == null || !(other instanceof TipologiaCard)) {
            return false;
        }
        TipologiaCard otherTipologiaCard = (TipologiaCard) other;
        return (getTipologiaCardId() == otherTipologiaCard.getTipologiaCardId());
    }

    @Override
    public int hashCode() {
        int intId = (int)(getTipologiaCardId()/1000);
    	return 37*intId + 97;
    }
}
