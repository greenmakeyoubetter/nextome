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
@Name(value = "tipologiaDisponibilita")
@Table(name = "14_tipologia_disponibilita")
public class TipologiaDisponibilita implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tipologia_disp_14")
	private Long tipologiaDisponibilitaId;		// PK counter
		
	@Column(name = "descrizione_tipologia_14")
	private String descrizioneDisponibilita;
	
	@Column(name = "fl_inLine_14")
	private String flInLine;
	
	
	@Column(name = "fl_servizio_14")
	private String flServizio;
	
	@Column(name = "fl_attivita_14")
	private String flAttivita;
	
	@Column(name = "fl_oggetto_14")
	private String flOggetto;
	

	public TipologiaDisponibilita() {
	}
	
	


public Long getTipologiaDisponibilitaId() {
		return tipologiaDisponibilitaId;
	}




	public void setTipologiaDisponibilitaId(Long tipologiaDisponibilitaId) {
		this.tipologiaDisponibilitaId = tipologiaDisponibilitaId;
	}




	public String getDescrizioneDisponibilita() {
		return descrizioneDisponibilita;
	}




	public void setDescrizioneDisponibilita(String descrizioneDisponibilita) {
		this.descrizioneDisponibilita = descrizioneDisponibilita;
	}




	public String getFlInLine() {
		return flInLine;
	}




	public void setFlInLine(String flInLine) {
		this.flInLine = flInLine;
	}




	public String getFlServizio() {
		return flServizio;
	}




	public void setFlServizio(String flServizio) {
		this.flServizio = flServizio;
	}




	public String getFlAttivita() {
		return flAttivita;
	}




	public void setFlAttivita(String flAttivita) {
		this.flAttivita = flAttivita;
	}




	public String getFlOggetto() {
		return flOggetto;
	}




	public void setFlOggetto(String flOggetto) {
		this.flOggetto = flOggetto;
	}




@Override
    public boolean equals(Object other) {
        if (other == null || !(other instanceof TipologiaDisponibilita)) {
            return false;
        }
        TipologiaDisponibilita otherTipologiaDisponibilita = (TipologiaDisponibilita) other;
        return (getTipologiaDisponibilitaId() == otherTipologiaDisponibilita.getTipologiaDisponibilitaId());
    }

    @Override
    public int hashCode() {
        int intId = (int)(getTipologiaDisponibilitaId()/1000);
    	return 37*intId + 97;
    }
}
