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
@Name(value = "interesse")
@Table(name = "23_interessi")
public class Interesse implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_interesse_23")
	private Long interesseId;		// PK counter
	
	@ManyToOne
	@JoinColumn(name = "utente_23")
	private Utente utenteInteresse;
	
	@ManyToOne
	@JoinColumn(name = "tema_23")
	private TemaCategoria temaCategoriaInteresse;
	
	@Column(name = "dt_dichiarazione_23")
	private Date dataDichiarazione;
	
	@Column(name = "dt_cancellazione")
	private Date dataCancellazione;
	
	
	public Date getDataCancellazione() {
		return dataCancellazione;
	}

	public void setDataCancellazione(Date dataCancellazione) {
		this.dataCancellazione = dataCancellazione;
	}

	public Long getInteresseId() {
		return interesseId;
	}

	public void setInteresseId(Long interesseId) {
		this.interesseId = interesseId;
	}

	public Utente getUtenteInteresse() {
		return utenteInteresse;
	}

	public void setUtenteInteresse(Utente utenteInteresse) {
		this.utenteInteresse = utenteInteresse;
	}

	public TemaCategoria getTemaCategoriaInteresse() {
		return temaCategoriaInteresse;
	}

	public void setTemaCategoriaInteresse(TemaCategoria temaCategoriaInteresse) {
		this.temaCategoriaInteresse = temaCategoriaInteresse;
	}

	public Date getDataDichiarazione() {
		return dataDichiarazione;
	}

	public void setDataDichiarazione(Date dataDichiarazione) {
		this.dataDichiarazione = dataDichiarazione;
	}

	public Interesse() {
	}

  @Override
    public boolean equals(Object other) {
        if (other == null || !(other instanceof Interesse)) {
            return false;
        }
        Interesse otherInteresse = (Interesse) other;
        return (getInteresseId() == otherInteresse.getInteresseId());
    }

    @Override
    public int hashCode() {
        int intId = (int)(getInteresseId()/1000);
    	return 37*intId + 97;
    }
}
