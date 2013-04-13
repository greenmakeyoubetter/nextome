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
@Name(value = "preferito")
@Table(name = "24_preferiti")
public class Preferito implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_preferiti")
	private Long preferitiId;		// PK counter
	
	@ManyToOne
	@JoinColumn(name = "espresso_da")
	private Utente utenteEsprimente;
	
	@ManyToOne
	@JoinColumn(name = "espresso_per")
	private Utente utenteInteressante;
	
	@Column(name = "dt_espressione")
	private Date dataEspressione;
	
	@Column(name = "dt_cancellazione")
	private Date dataCancellazioneEspressione;
	
	

	public Long getPreferitiId() {
		return preferitiId;
	}

	public void setPreferitiId(Long preferitiId) {
		this.preferitiId = preferitiId;
	}

	public Utente getUtenteEsprimente() {
		return utenteEsprimente;
	}

	public void setUtenteEsprimente(Utente utenteEsprimente) {
		this.utenteEsprimente = utenteEsprimente;
	}

	public Utente getUtenteInteressante() {
		return utenteInteressante;
	}

	public void setUtenteInteressante(Utente utenteInteressante) {
		this.utenteInteressante = utenteInteressante;
	}

	public Date getDataEspressione() {
		return dataEspressione;
	}

	public void setDataEspressione(Date dataEspressione) {
		this.dataEspressione = dataEspressione;
	}

	public Date getDataCancellazioneEspressione() {
		return dataCancellazioneEspressione;
	}

	public void setDataCancellazioneEspressione(Date dataCancellazioneEspressione) {
		this.dataCancellazioneEspressione = dataCancellazioneEspressione;
	}

	public Preferito() {
	}

  @Override
    public boolean equals(Object other) {
        if (other == null || !(other instanceof Preferito)) {
            return false;
        }
        Preferito otherPreferito = (Preferito) other;
        return (getPreferitiId() == otherPreferito.getPreferitiId());
    }

    @Override
    public int hashCode() {
        int intId = (int)(getPreferitiId()/1000);
    	return 37*intId + 97;
    }
}
