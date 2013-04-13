package com.mydomain.pkg.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import static org.jboss.seam.ScopeType.SESSION;


import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;

import javax.persistence.Column;
import javax.persistence.Table;

@Entity
@Scope(org.jboss.seam.ScopeType.SESSION)
@Table(name = "5_utenti")
@Name("utente")
public class Utente implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_utenti_5")
	private Long utenteId;
	
	@Column(name = "mail_utente_5")
	private String mailUtente; // PK
	
	@Column(name = "password_utente_5")
	private String passUtente; // PK
	
	@Column(name = "img_utente_5")
	private String imgUtente;
	
	@Column(name = "fl_utente_5")
	private String flUtente;
	
	@Column(name = "codice_fiscale_6")
	private String codiceFiscale;
	
	@Column(name = "indirizzo_domicilio_utente_6")
	private String indirizzoPrivato;
	
	@ManyToOne
	@JoinColumn(name = "zona_domicilio_utente_6")
	private Zona zonaDomicilio;
	
	@Column(name = "nome_privato_6")
	private String nomePrivato;
	
	@Column(name = "cognome_privato_6")
	private String cognomePrivato;
	
	@Column(name = "partita_iva_7")
	private String partitaIva;
	
	@Column(name = "ragione_sociale_7")
	private String ragioneSocialeAzienda;
	
	@ManyToOne
	@JoinColumn(name = "zona_sede_7")
	private Zona zonaSede;
	
	@Column(name = "indirizzo_sede_7")
	private String indirizzoSede;
	
	@Column(name = "chi_sono_5")
	private String chiSono;
	
	@Column(name = "username_5")
	private String username;
	
	@Column(name = "data_nascita_6")
	private Date dtNascita;
	
	@Column(name = "sesso_6")
	private String sesso;
	
	public Utente() {}



	public Long getUtenteId() {
		return utenteId;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public void setUtenteId(Long utenteId) {
		this.utenteId = utenteId;
	}



	public String getMailUtente() {
		return mailUtente;
	}



	public void setMailUtente(String mailUtente) {
		this.mailUtente = mailUtente;
	}





	public String getPassUtente() {
		return passUtente;
	}



	public void setPassUtente(String passUtente) {
		this.passUtente = passUtente;
	}



	public String getImgUtente() {
		return imgUtente;
	}



	public void setImgUtente(String imgUtente) {
		this.imgUtente = imgUtente;
	}



	public String getCodiceFiscale() {
		return codiceFiscale;
	}



	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}



	public String getIndirizzoPrivato() {
		return indirizzoPrivato;
	}



	public void setIndirizzoPrivato(String indirizzoPrivato) {
		this.indirizzoPrivato = indirizzoPrivato;
	}



	public Zona getZonaDomicilio() {
		return zonaDomicilio;
	}



	public void setZonaDomicilio(Zona zonaDomicilio) {
		this.zonaDomicilio = zonaDomicilio;
	}



	public String getNomePrivato() {
		return nomePrivato;
	}



	public void setNomePrivato(String nomePrivato) {
		this.nomePrivato = nomePrivato;
	}



	public String getCognomePrivato() {
		return cognomePrivato;
	}



	public void setCognomePrivato(String cognomePrivato) {
		this.cognomePrivato = cognomePrivato;
	}



	public String getPartitaIva() {
		return partitaIva;
	}



	public void setPartitaIva(String partitaIva) {
		this.partitaIva = partitaIva;
	}



	public String getRagioneSocialeAzienda() {
		return ragioneSocialeAzienda;
	}



	public void setRagioneSocialeAzienda(String ragioneSocialeAzienda) {
		this.ragioneSocialeAzienda = ragioneSocialeAzienda;
	}



	public Zona getZonaSede() {
		return zonaSede;
	}



	public void setZonaSede(Zona zonaSede) {
		this.zonaSede = zonaSede;
	}



	public String getIndirizzoSede() {
		return indirizzoSede;
	}



	public void setIndirizzoSede(String indirizzoSede) {
		this.indirizzoSede = indirizzoSede;
	}

	
	

	public String getFlUtente() {
		return flUtente;
	}



	public void setFlUtente(String flUtente) {
		this.flUtente = flUtente;
	}



	public String getChiSono() {
		return chiSono;
	}



	public void setChiSono(String chiSono) {
		this.chiSono = chiSono;
	}

	
	


	public Date getDtNascita() {
		return dtNascita;
	}



	public void setDtNascita(Date dtNascita) {
		this.dtNascita = dtNascita;
	}



	public String getSesso() {
		return sesso;
	}



	public void setSesso(String sesso) {
		this.sesso = sesso;
	}



	@Override
	    public boolean equals(Object other) {
	        if (other == null || !(other instanceof Utente)) {
	            return false;
	        }
	        Utente otherUtente = (Utente) other;
	        return (getUtenteId() == otherUtente.getUtenteId());
	    }

	    @Override
	    public int hashCode() {
	        int intId = (int)(getUtenteId()/1000);
	    	return 37*intId + 97;
	    }
	
	
}
