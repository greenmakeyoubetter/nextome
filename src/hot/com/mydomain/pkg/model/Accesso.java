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
@Name(value = "accesso")
@Table(name = "8_accessi")
public class Accesso implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_accesso_8")
	private Long accessoId;		// PK counter
	
	@ManyToOne
	@JoinColumn(name = "utente_accesso_8")
	private Utente accessoSoggetto;
	
	@Column(name = "data_attivazione_8")
	private Date dataAttivazioneAccesso;
	
	@Column(name = "data_disattivazione_8")
	private Date dataDisattivazioneAccesso;
	
	
	
	
	
	
	public Long getAccessoId() {
		return accessoId;
	}

	public void setAccessoId(Long accessoId) {
		this.accessoId = accessoId;
	}


	public Utente getAccessoSoggetto() {
		return accessoSoggetto;
	}

	public void setAccessoSoggetto(Utente accessoSoggetto) {
		this.accessoSoggetto = accessoSoggetto;
	}

	public Date getDataAttivazioneAccesso() {
		return dataAttivazioneAccesso;
	}

	public void setDataAttivazioneAccesso(Date dataAttivazioneAccesso) {
		this.dataAttivazioneAccesso = dataAttivazioneAccesso;
	}

	public Date getDataDisattivazioneAccesso() {
		return dataDisattivazioneAccesso;
	}

	public void setDataDisattivazioneAccesso(Date dataDisattivazioneAccesso) {
		this.dataDisattivazioneAccesso = dataDisattivazioneAccesso;
	}

	public Accesso() {
	}

  @Override
    public boolean equals(Object other) {
        if (other == null || !(other instanceof Accesso)) {
            return false;
        }
        Accesso otherAccesso = (Accesso) other;
        return (getAccessoId() == otherAccesso.getAccessoId());
    }

    @Override
    public int hashCode() {
        int intId = (int)(getAccessoId()/1000);
    	return 37*intId + 97;
    }
}
