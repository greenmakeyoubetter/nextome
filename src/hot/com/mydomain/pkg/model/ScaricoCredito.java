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
@Name(value = "scaricoCredito")
@Table(name = "19_scarico_crediti")
public class ScaricoCredito implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_scarico_credito_19")
	private Long scaricoId;		// PK counter

	
	@Column(name = "quantita_scaricata_19")
	private Double quantitaScaricata;
	
	@Column(name = "dt_scarico_19")
	private Date dtScarico;
	
	@ManyToOne
	@JoinColumn(name = "credito_19")
	private CreditoUtente credito;
	
	@ManyToOne
	@JoinColumn(name = "scaricato_con_19")
	private RichiestaCondivisione scaricatoCon;
	

	
	
	public ScaricoCredito() {
	}







public Long getScaricoId() {
		return scaricoId;
	}







	public void setScaricoId(Long scaricoId) {
		this.scaricoId = scaricoId;
	}







	public Double getQuantitaScaricata() {
		return quantitaScaricata;
	}







	public void setQuantitaScaricata(Double quantitaScaricata) {
		this.quantitaScaricata = quantitaScaricata;
	}







	public Date getDtScarico() {
		return dtScarico;
	}







	public void setDtScarico(Date dtScarico) {
		this.dtScarico = dtScarico;
	}







	public CreditoUtente getCredito() {
		return credito;
	}







	public void setCredito(CreditoUtente credito) {
		this.credito = credito;
	}







	public RichiestaCondivisione getScaricatoCon() {
		return scaricatoCon;
	}







	public void setScaricatoCon(RichiestaCondivisione scaricatoCon) {
		this.scaricatoCon = scaricatoCon;
	}







@Override
    public boolean equals(Object other) {
        if (other == null || !(other instanceof ScaricoCredito)) {
            return false;
        }
        ScaricoCredito otherScaricoCredito = (ScaricoCredito) other;
        return (getScaricoId() == otherScaricoCredito.getScaricoId());
    }

    @Override
    public int hashCode() {
        int intId = (int)(getScaricoId()/1000);
    	return 37*intId + 97;
    }
}
