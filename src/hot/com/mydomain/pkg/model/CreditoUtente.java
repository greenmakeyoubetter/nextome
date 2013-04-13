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
@Name(value = "creditoUtente")
@Table(name = "18_crediti_utenti")
public class CreditoUtente implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_credito_utente")
	private Long creditoId;		// PK counter
		
	@Column(name = "quantita_acquistata_18")
	private Double quantitaAcquistata;
	
	@Column(name = "quantita_residua_18")
	private Double quantitaResidua;
	
	@Column(name = "dt_acquisizione_credito_18")
	private Date dtAcquisizione;
	
	@ManyToOne
	@JoinColumn(name = "utente_18")
	private Utente utenteCredito;
	
	@ManyToOne
	@JoinColumn(name = "card_acquistata_18")
	private Card cardAcquistata;
	

	
	
	public CreditoUtente() {
	}




public Long getCreditoId() {
		return creditoId;
	}




	public void setCreditoId(Long creditoId) {
		this.creditoId = creditoId;
	}




	public Double getQuantitaAcquistata() {
		return quantitaAcquistata;
	}




	public void setQuantitaAcquistata(Double quantitaAcquistata) {
		this.quantitaAcquistata = quantitaAcquistata;
	}




	public Double getQuantitaResidua() {
		return quantitaResidua;
	}




	public void setQuantitaResidua(Double quantitaResidua) {
		this.quantitaResidua = quantitaResidua;
	}




	public Date getDtAcquisizione() {
		return dtAcquisizione;
	}




	public void setDtAcquisizione(Date dtAcquisizione) {
		this.dtAcquisizione = dtAcquisizione;
	}




	public Utente getUtenteCredito() {
		return utenteCredito;
	}




	public void setUtenteCredito(Utente utenteCredito) {
		this.utenteCredito = utenteCredito;
	}




	public Card getCardAcquistata() {
		return cardAcquistata;
	}




	public void setCardAcquistata(Card cardAcquistata) {
		this.cardAcquistata = cardAcquistata;
	}




@Override
    public boolean equals(Object other) {
        if (other == null || !(other instanceof CreditoUtente)) {
            return false;
        }
        CreditoUtente otherCreditoUtente = (CreditoUtente) other;
        return (getCreditoId() == otherCreditoUtente.getCreditoId());
    }

    @Override
    public int hashCode() {
        int intId = (int)(getCreditoId()/1000);
    	return 37*intId + 97;
    }
}
