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
@Name(value = "comune")
@Table(name = "3_comuni")
public class Comune implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_comune_3")
	private Long comuneId;		// PK counter
	
	@ManyToOne
	@JoinColumn(name = "provincia_comune_3")
	private Provincia provinciaComune;
	
		
	@Column(name = "nome_comune_3")
	private String nomeComune;
	
	


	public Long getComuneId() {
		return comuneId;
	}

	public void setComuneId(Long comuneId) {
		this.comuneId = comuneId;
	}

	public Provincia getProvinciaComune() {
		return provinciaComune;
	}

	public void setProvinciaComune(Provincia provinciaComune) {
		this.provinciaComune = provinciaComune;
	}


	public String getNomeComune() {
		return nomeComune;
	}

	public void setNomeComune(String nomeComune) {
		this.nomeComune = nomeComune;
	}

	public Comune() {
	}

  @Override
    public boolean equals(Object other) {
        if (other == null || !(other instanceof Comune)) {
            return false;
        }
        Comune otherComune = (Comune) other;
        return (getComuneId() == otherComune.getComuneId());
    }

    @Override
    public int hashCode() {
        int intId = (int)(getComuneId()/1000);
    	return 37*intId + 97;
    }
}
