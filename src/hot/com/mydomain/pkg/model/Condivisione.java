package com.mydomain.pkg.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.jboss.seam.annotations.Name;

import javax.persistence.Column;
import javax.persistence.Table;

@Entity
//@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "10_condivisioni")
@Name(value = "condivisione")
public class Condivisione implements Serializable{

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_condivisione_10")
	private Long condivisioneId;		// PK counter
	
	@ManyToOne
	@JoinColumn(name = "utente_condivisione_10")
	private Utente utenteCondivisione;
	
	@Column(name = "dt_inserimento_10")
	private Date dtInserimentoCondivisione;
	
	@Column(name = "img_condivisione_10")
	private String imgCondivisione;
	
	@Column(name = "fl_condivisione_10")
	private String flCondivisione;

	@Column(name = "descrizione_attivita_11")
	private String descrizioneAttivita;
	
	@ManyToOne
	@JoinColumn(name = "zona_svolgimento_attivita_11")
	private Zona zonaSvolgimentoAttivita;
	
	@Column(name = "dt_inizio_attivita_11")
	private Date dtInizioAttivita;
	
	@Column(name = "dt_fine_attivita_11")
	private Date dtFineAttivita;
	
	@Column(name = "indirizzo_svolgimento_attivita_11")
	private String indirizzoSvolgimentoAttivita;
		
	@Column(name = "descrizione_oggetto_12")
	private String descrizioneOggetto;
	
	@Column(name = "valore_di_mercato_12")
	private Double valoreMercato;

	@Column(name = "descrizione_servizio_13")
	private String descrizioneServizio;

	public Condivisione() {
	}

	public Long getCondivisioneId() {
		return condivisioneId;
	}

	public void setCondivisioneId(Long condivisioneId) {
		this.condivisioneId = condivisioneId;
	}

	public Utente getUtenteCondivisione() {
		return utenteCondivisione;
	}

	public void setUtenteCondivisione(Utente utenteCondivisione) {
		this.utenteCondivisione = utenteCondivisione;
	}

	public Date getDtInserimentoCondivisione() {
		return dtInserimentoCondivisione;
	}

	public void setDtInserimentoCondivisione(Date dtInserimentoCondivisione) {
		this.dtInserimentoCondivisione = dtInserimentoCondivisione;
	}

	public String getImgCondivisione() {
		return imgCondivisione;
	}

	public void setImgCondivisione(String imgCondivisione) {
		this.imgCondivisione = imgCondivisione;
	}

	

	public String getDescrizioneAttivita() {
		return descrizioneAttivita;
	}

	public void setDescrizioneAttivita(String descrizioneAttivita) {
		this.descrizioneAttivita = descrizioneAttivita;
	}

	public Zona getZonaSvolgimentoAttivita() {
		return zonaSvolgimentoAttivita;
	}

	public void setZonaSvolgimentoAttivita(Zona zonaSvolgimentoAttivita) {
		this.zonaSvolgimentoAttivita = zonaSvolgimentoAttivita;
	}

	public Date getDtInizioAttivita() {
		return dtInizioAttivita;
	}

	public void setDtInizioAttivita(Date dtInizioAttivita) {
		this.dtInizioAttivita = dtInizioAttivita;
	}

	public Date getDtFineAttivita() {
		return dtFineAttivita;
	}

	public void setDtFineAttivita(Date dtFineAttivita) {
		this.dtFineAttivita = dtFineAttivita;
	}

	public String getIndirizzoSvolgimentoAttivita() {
		return indirizzoSvolgimentoAttivita;
	}

	public void setIndirizzoSvolgimentoAttivita(String indirizzoSvolgimentoAttivita) {
		this.indirizzoSvolgimentoAttivita = indirizzoSvolgimentoAttivita;
	}

	public String getDescrizioneOggetto() {
		return descrizioneOggetto;
	}

	public void setDescrizioneOggetto(String descrizioneOggetto) {
		this.descrizioneOggetto = descrizioneOggetto;
	}

	public Double getValoreMercato() {
		return valoreMercato;
	}

	public void setValoreMercato(Double valoreMercato) {
		this.valoreMercato = valoreMercato;
	}

	public String getDescrizioneServizio() {
		return descrizioneServizio;
	}

	public void setDescrizioneServizio(String descrizioneServizio) {
		this.descrizioneServizio = descrizioneServizio;
	}
	
	public String getFlCondivisione() {
		return flCondivisione;
	}

	public void setFlCondivisione(String flCondivisione) {
		this.flCondivisione = flCondivisione;
	}

	@Override
    public boolean equals(Object other) {
        if (other == null || !(other instanceof Condivisione)) {
            return false;
        }
        Condivisione otherCondivisione = (Condivisione) other;
        return (getCondivisioneId() == otherCondivisione.getCondivisioneId());
    }

    @Override
    public int hashCode() {
        int intId = (int)(getCondivisioneId()/1000);
    	return 37*intId + 97;
    }

}
