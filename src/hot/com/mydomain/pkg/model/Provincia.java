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
@Name(value = "provincia")
@Table(name = "2_province")
public class Provincia implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_provincia_2")
	private Long provinciaId;		// PK counter
	
	@ManyToOne
	@JoinColumn(name = "regione_provincia_2")
	private Regione regioneProvincia;
	
	@Column(name = "nome_provincia_2")
	private String nomeProvincia;
	
	@Column(name = "sigla_provincia_2")
	private String siglaProvincia;
	
	
	public Long getProvinciaId() {
		return provinciaId;
	}

	public void setProvinciaId(Long provinciaId) {
		this.provinciaId = provinciaId;
	}

	

	public Regione getRegioneProvincia() {
		return regioneProvincia;
	}

	public void setRegioneProvincia(Regione regioneProvincia) {
		this.regioneProvincia = regioneProvincia;
	}

	public String getNomeProvincia() {
		return nomeProvincia;
	}

	public void setNomeProvincia(String nomeProvincia) {
		this.nomeProvincia = nomeProvincia;
	}

	public String getSiglaProvincia() {
		return siglaProvincia;
	}

	public void setSiglaProvincia(String siglaProvincia) {
		this.siglaProvincia = siglaProvincia;
	}

	public Provincia() {
	}

  @Override
    public boolean equals(Object other) {
        if (other == null || !(other instanceof Provincia)) {
            return false;
        }
        Provincia otherProvincia = (Provincia) other;
        return (getProvinciaId() == otherProvincia.getProvinciaId());
    }

    @Override
    public int hashCode() {
        int intId = (int)(getProvinciaId()/1000);
    	return 37*intId + 97;
    }
}
