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
@Name(value = "zona")
@Table(name = "4_zone")
public class Zona implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_zona")
	private Long zonaId;		// PK counter
	
	@ManyToOne
	@JoinColumn(name = "comune_zona_4")
	private Comune comuneZona;
	
	@Column(name = "nome_zona_4")
	private String nomeZona;
	
	@Column(name = "cap_zona_4")
	private String capZona;
	

	public Zona() {
	}
	
	
	
	
	

  public Long getZonaId() {
		return zonaId;
	}






	public void setZonaId(Long zonaId) {
		this.zonaId = zonaId;
	}






	public Comune getComuneZona() {
		return comuneZona;
	}






	public void setComuneZona(Comune comuneZona) {
		this.comuneZona = comuneZona;
	}






	public String getNomeZona() {
		return nomeZona;
	}






	public void setNomeZona(String nomeZona) {
		this.nomeZona = nomeZona;
	}






	public String getCapZona() {
		return capZona;
	}






	public void setCapZona(String capZona) {
		this.capZona = capZona;
	}






@Override
    public boolean equals(Object other) {
        if (other == null || !(other instanceof Zona)) {
            return false;
        }
        Zona otherZona = (Zona) other;
        return (getZonaId() == otherZona.getZonaId());
    }

    @Override
    public int hashCode() {
        int intId = (int)(getZonaId()/1000);
    	return 37*intId + 97;
    }
}
