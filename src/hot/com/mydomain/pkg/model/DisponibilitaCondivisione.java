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
@Name(value = "disponibilitaCondivisione")
@Table(name = "15_disponibilita_condivisione")
public class DisponibilitaCondivisione implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_disponibilita_condivisione_15")
	private Long disponibilitaCondivisioneId;		// PK counter
		
	@ManyToOne
	@JoinColumn(name = "tipologia_disponibilita_15")
	private TipologiaDisponibilita tipologiaDisponibilita;
	
	@ManyToOne
	@JoinColumn(name = "condivisione_15")
	private Condivisione condivisioneDisponibilita;
		
	@Column(name = "prezzo_15")
	private Double prezzoCondivisione;
	
	public DisponibilitaCondivisione() {
	}
	



public Long getDisponibilitaCondivisioneId() {
		return disponibilitaCondivisioneId;
	}




	public void setDisponibilitaCondivisioneId(Long disponibilitaCondivisioneId) {
		this.disponibilitaCondivisioneId = disponibilitaCondivisioneId;
	}




	public TipologiaDisponibilita getTipologiaDisponibilita() {
		return tipologiaDisponibilita;
	}




	public void setTipologiaDisponibilita(
			TipologiaDisponibilita tipologiaDisponibilita) {
		this.tipologiaDisponibilita = tipologiaDisponibilita;
	}




	public Condivisione getCondivisioneDisponibilita() {
		return condivisioneDisponibilita;
	}




	public void setCondivisioneDisponibilita(Condivisione condivisioneDisponibilita) {
		this.condivisioneDisponibilita = condivisioneDisponibilita;
	}




	public Double getPrezzoCondivisione() {
		return prezzoCondivisione;
	}




	public void setPrezzoCondivisione(Double prezzoCondivisione) {
		this.prezzoCondivisione = prezzoCondivisione;
	}




@Override
    public boolean equals(Object other) {
        if (other == null || !(other instanceof DisponibilitaCondivisione)) {
            return false;
        }
        DisponibilitaCondivisione otherDisponibilitaCondivisione = (DisponibilitaCondivisione) other;
        return (getDisponibilitaCondivisioneId() == otherDisponibilitaCondivisione.getDisponibilitaCondivisioneId());
    }

    @Override
    public int hashCode() {
        int intId = (int)(getDisponibilitaCondivisioneId()/1000);
    	return 37*intId + 97;
    }
}
