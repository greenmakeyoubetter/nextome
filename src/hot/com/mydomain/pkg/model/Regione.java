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
@Name(value = "regione")
@Table(name = "1_regioni")
public class Regione implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_regione_1")
	private Long regioneId;		// PK counter
		
	@Column(name = "nome_regione_1")
	private String nomeRegione;
	
	
	public Long getRegioneId() {
		return regioneId;
	}

	public void setRegioneId(Long regioneId) {
		this.regioneId = regioneId;
	}

	public String getNomeRegione() {
		return nomeRegione;
	}

	public void setNomeRegione(String nomeRegione) {
		this.nomeRegione = nomeRegione;
	}

	public Regione() {
	}

  @Override
    public boolean equals(Object other) {
        if (other == null || !(other instanceof Regione)) {
            return false;
        }
        Regione otherRegione = (Regione) other;
        return (getRegioneId() == otherRegione.getRegioneId());
    }

    @Override
    public int hashCode() {
        int intId = (int)(getRegioneId()/1000);
    	return 37*intId + 97;
    }
}
