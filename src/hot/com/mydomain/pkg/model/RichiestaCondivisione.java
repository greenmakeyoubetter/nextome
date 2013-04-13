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
@Name(value = "richiestaCondivisione")
@Table(name = "16_richieste_condivisione")
public class RichiestaCondivisione implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_richiesta_16")
	private Long richiestaId;		// PK counter
		
	@ManyToOne
	@JoinColumn(name = "tipologia_richiesta_16")
	private DisponibilitaCondivisione disponibilitaCondivisione;
	
		
	@ManyToOne
	@JoinColumn(name = "richiesta_da_16")
	private Utente richiedente;
	

	@Column(name = "dt_richiesta_16")
	private Date dataRichiesta;
	
	@Column(name = "dt_visualizzazione_16")
	private Date dataVisualizzazione;
	
	@Column(name = "fl_accettazione_16")
	private String flAccettazione;
	
	@Column(name = "richiesta_per_16")
	private Date richiestaPer;
	
	
	@ManyToOne
	@JoinColumn(name = "richiesta_a_16")
	private Utente richiestaA;
	
	
	public RichiestaCondivisione() {
	}
	







public Long getRichiestaId() {
		return richiestaId;
	}








	public Utente getRichiestaA() {
	return richiestaA;
}








public void setRichiestaA(Utente richiestaA) {
	this.richiestaA = richiestaA;
}








	public void setRichiestaId(Long richiestaId) {
		this.richiestaId = richiestaId;
	}








	public DisponibilitaCondivisione getDisponibilitaCondivisione() {
		return disponibilitaCondivisione;
	}








	public void setDisponibilitaCondivisione(
			DisponibilitaCondivisione disponibilitaCondivisione) {
		this.disponibilitaCondivisione = disponibilitaCondivisione;
	}








	public Utente getRichiedente() {
		return richiedente;
	}








	public void setRichiedente(Utente richiedente) {
		this.richiedente = richiedente;
	}








	public Date getDataRichiesta() {
		return dataRichiesta;
	}








	public void setDataRichiesta(Date dataRichiesta) {
		this.dataRichiesta = dataRichiesta;
	}








	public Date getDataVisualizzazione() {
		return dataVisualizzazione;
	}








	public void setDataVisualizzazione(Date dataVisualizzazione) {
		this.dataVisualizzazione = dataVisualizzazione;
	}








	public Date getRichiestaPer() {
		return richiestaPer;
	}








	public void setRichiestaPer(Date richiestaPer) {
		this.richiestaPer = richiestaPer;
	}








	public String getFlAccettazione() {
		return flAccettazione;
	}



	public void setFlAccettazione(String flAccettazione) {
		this.flAccettazione = flAccettazione;
	}



@Override
    public boolean equals(Object other) {
        if (other == null || !(other instanceof RichiestaCondivisione)) {
            return false;
        }
        RichiestaCondivisione otherRichiestaCondivisione = (RichiestaCondivisione) other;
        return (getRichiestaId() == otherRichiestaCondivisione.getRichiestaId());
    }

    @Override
    public int hashCode() {
        int intId = (int)(getRichiestaId()/1000);
    	return 37*intId + 97;
    }
}
