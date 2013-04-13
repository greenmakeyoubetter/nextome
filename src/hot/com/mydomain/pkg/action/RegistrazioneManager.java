package com.mydomain.pkg.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import static org.jboss.seam.ScopeType.SESSION;
import java.util.List;
import org.jboss.seam.contexts.Context;
import org.jboss.seam.contexts.Contexts;
import java.util.Map;

import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.validator.ValidatorException;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.brickred.socialauth.AuthProvider;
import org.brickred.socialauth.Profile;
import org.brickred.socialauth.SocialAuthConfig;
import org.brickred.socialauth.SocialAuthManager;
import org.brickred.socialauth.util.SocialAuthUtil;
import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Destroy;
import org.jboss.seam.annotations.Factory;
import org.jboss.seam.annotations.FlushModeType;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.annotations.datamodel.DataModel;
import org.jboss.seam.annotations.datamodel.DataModelSelection;
import org.jboss.seam.core.Conversation;
import org.jboss.seam.faces.FacesMessages;
import org.jboss.seam.log.Log;
import org.jboss.seam.security.Credentials;
import org.jboss.seam.security.Identity;
import org.jboss.seam.web.Session;
import org.primefaces.event.FlowEvent;

import com.mydomain.pkg.model.Accesso;
import com.mydomain.pkg.model.ProfiloSocial;
import com.mydomain.pkg.model.Social;
import com.mydomain.pkg.model.Utente;
import com.mydomain.pkg.model.Zona;


@Stateful
@Name("registrazioneManager")
public class RegistrazioneManager implements RegistrazioneManagerInterface{
	
	
	@Logger
	Log log;
		
		
	@In
	EntityManager entityManager;//
	
	
	@In
	FacesMessages facesMessages;//
	
	
	@In(required=false)
	@Out(required=false)
	List<Zona> zonaSuggest;
	
	@In(required=false)
	@Out(required=false)
	Utente utente;
	
	private byte[] uploadedFile;

	private String pictureName;	

	private String contentType;
	
	String confermaPass;
	
	boolean reg ;
	
	@In(required=false)
	@Out(required=false)
	ProfiloSocial prSocial;
	
	
	/* ANCILLARY METHODS */	
	@Remove
	@Destroy
	public void remove() {}
	

	/*
@DataModel

*/
	
	List<Zona> listZona;
	
	
	public List<Zona> getListZona() {
		return listZona;
	}

	public void setListZona(List<Zona> listZona) {
		this.listZona = listZona;
	}


	//@DataModel
	List<String> capString;

  //  @Factory("capString")
	public void cercaZonaString(){

    capString = new ArrayList();
	capString = entityManager.createQuery("Select n.capZona from Zona as n").getResultList();
	
	} 
	
	
	
	
	
	public void cercaZona(){
        listZona = new ArrayList();	
	    listZona = entityManager.createQuery("Select n from Zona as n").getResultList();
	    zonaSuggest =  new ArrayList();
	    zonaSuggest = listZona;

		} 
    
	public List<Zona> getZona(){
       List<Zona> listZona2 = new ArrayList();	
	
	    listZona2 = entityManager.createQuery("Select n from Zona as n").getResultList();
		return listZona2;

		} 
	
	
	public List<Zona> autocomplete(Object suggest) {
		
        String pref = (String)suggest;
    
        ArrayList<Zona> result = new ArrayList<Zona>();
    
        Iterator iterator = getZona().iterator();
    	
        while (iterator.hasNext()) {
        	
            Zona elem = ((Zona) iterator.next());
        	
            if ((elem.getCapZona() != null && elem.getCapZona().toLowerCase().indexOf(pref.toLowerCase()) == 0) || "".equals(pref))
            {	
                result.add(elem);
            }
       
        }
        return result;
    }
	
	public List<Zona> getZonaSede(){
	       List<Zona> listZona2 = new ArrayList();	
		
		    listZona2 = entityManager.createQuery("Select n from Zona as n").getResultList();
			return listZona2;

			} 
		
		
		public List<Zona> autocompleteSede(Object suggest) {
			
	        String pref = (String)suggest;
	    
	        ArrayList<Zona> result = new ArrayList<Zona>();
	    
	        Iterator iterator = getZona().iterator();
	    	
	        while (iterator.hasNext()) {
	        	
	            Zona elem = ((Zona) iterator.next());
	        	
	            if ((elem.getCapZona() != null && elem.getCapZona().toLowerCase().indexOf(pref.toLowerCase()) == 0) || "".equals(pref))
	            {	
	                result.add(elem);
	            }
	       
	        }
	        return result;
	    }
		
	
	
    String zonaString;
	 
	Zona zonaRegistrazione;

	
	public List<String> getCapString() {
		return capString;
	}

	public void setCapString(List<String> capString) {
		this.capString = capString;
	}

	
	public Zona getZonaRegistrazione() {
		return zonaRegistrazione;
	}

	public void setZonaRegistrazione(Zona zonaRegistrazione) {
		this.zonaRegistrazione = zonaRegistrazione;
	}

	public String getZonaString() {
		return zonaString;
	}

	public void setZonaString(String zonaString) {
		this.zonaString = zonaString;
	}
	
	
	
	
	
	
	
	
	
	
	public byte[] getUploadedFile() {
		return uploadedFile;
	}

	public void setUploadedFile(byte[] uploadedFile) {
		this.uploadedFile = uploadedFile;
	}

	public String getPictureName() {
		return pictureName;
	}

	public void setPictureName(String pictureName) {
		this.pictureName = pictureName;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}


	public String getConfermaPass() {
		return confermaPass;
	}

	public void setConfermaPass(String confermaPass) {
		this.confermaPass = confermaPass;
	}

	public String  salvaUtente() {
		
		
		
			utente.setIndirizzoSede(null);
			utente.setZonaSede(null);
			utente.setRagioneSocialeAzienda(null);
			utente.setPartitaIva(null);
			utente.setFlUtente("P");

		try {
	    String hashPasswordFornita = md5hash(utente.getPassUtente());
	    utente.setPassUtente(hashPasswordFornita);
		entityManager.persist(utente);
		Accesso accesso = new Accesso();
		accesso.setAccessoSoggetto(utente);
		accesso.setDataAttivazioneAccesso(new Date());
		entityManager.persist(accesso);	
		 Social fb = new Social();
         fb = (Social) entityManager.createQuery("Select n from Social as n where n.nomeSocial = :param1").setParameter("param1", "FACEBOOK").getSingleResult();
         
	            prSocial = new ProfiloSocial();
        		prSocial.setSocialProfilo(fb);
        		prSocial.setUtenteSocial(utente);
        		prSocial.setImmagineSocial("/img/seamlogo.png");
        	    entityManager.persist(prSocial); 
        	    FacesMessage msg = new FacesMessage("Registrazione avvenuta correttamente! grazie per esserti unito a Nextome", "Benvenuto :" + utente.getUsername());  
                FacesContext.getCurrentInstance().addMessage(null, msg); 
        		
		
		  utente = new Utente();
		  accesso = new Accesso();
		  prSocial = new ProfiloSocial();
		  reg = true;
		  log.info("success");
		  return "success";
		 
	 }
		catch(Exception e) {
			FacesMessage msg = new FacesMessage("Si è verificato un errore, ti invitiamo a riprovare! Ci scusiamo per il disagio.");  
	        FacesContext.getCurrentInstance().addMessage(null, msg); 
	        utente = new Utente();
			prSocial = new ProfiloSocial();
			reg = false;
			  log.info("insuccess");
		    return "insuccess";
			
		}
		
		
	}
	
	   String zonaString2;

	public String getZonaString2() {
		return zonaString2;
	}

	public void setZonaString2(String zonaString2) {
		this.zonaString2 = zonaString2;
	}
	   
	public String md5hash(String password) {
        String hashString = null;
        try {
            java.security.MessageDigest digest = java.security.MessageDigest.getInstance("MD5");
            byte[] hash = digest.digest(password.getBytes());
            hashString = "";
            for (int i = 0; i < hash.length; i++) {
                hashString += Integer.toHexString( 
                                  (hash[i] & 0xFF) | 0x100 
                              ).toLowerCase().substring(1,3);
            }
        } catch (java.security.NoSuchAlgorithmException e) {
        	log.info(e);
        }
        return hashString;
    }

	public boolean isReg() {
		return reg;
	}

	public void setReg(boolean reg) {
		this.reg = reg;
	}
	   
	
	
	public void dummy(){
		log.info("Utente :" +utente.getUsername());
	}
	
public String salvaUtenteAzienda(){
		
			utente.setIndirizzoSede(null);
			utente.setZonaSede(null);
			utente.setRagioneSocialeAzienda(null);
			utente.setPartitaIva(null);
			utente.setFlUtente("A");
		    utente.setIndirizzoPrivato(null);
			utente.setZonaDomicilio(null);
			utente.setCognomePrivato(null);
			utente.setCodiceFiscale(null);
			utente.setNomePrivato(null);		
		try {
	    String hashPasswordFornita = md5hash(utente.getPassUtente());
	    utente.setPassUtente(hashPasswordFornita);
		entityManager.persist(utente);
		Accesso accesso = new Accesso();
		accesso.setAccessoSoggetto(utente);
		accesso.setDataAttivazioneAccesso(new Date());
		entityManager.persist(accesso);
		 Social fb = new Social();
         fb = (Social) entityManager.createQuery("Select n from Social as n where n.nomeSocial = :param1").setParameter("param1", "FACEBOOK").getSingleResult();
        
	            prSocial = new ProfiloSocial();
        		prSocial.setSocialProfilo(fb);
        		prSocial.setUtenteSocial(utente);
        		prSocial.setImmagineSocial("/img/seamlogo.png");
        		entityManager.persist(prSocial); 
        		
        FacesMessage msg = new FacesMessage("Registrazione avvenuta correttamente! grazie per esserti unito a Nextome", "Benvenuto :" + utente.getUsername());  
        FacesContext.getCurrentInstance().addMessage(null, msg); 
		
		
		utente = new Utente();
		accesso = new Accesso();
		prSocial = new ProfiloSocial();
		reg = true;
		return "success";
	
	}
		catch(Exception e) {
			facesMessages = new FacesMessages();
			facesMessages.add("Si è verificato un errore, ti invitiamo a riprovare! Ci scusiamo per il disagio.");
			reg = false;
			return "insuccess";
		}
		
		
	}



public boolean skip;


public boolean isSkip() {
	return skip;
}

public void setSkip(boolean skip) {
	this.skip = skip;
}  



public String onFlowProcess(FlowEvent event) {
	log.info("Current wizard step:" + event.getOldStep());
	log.info("Next step:" + event.getNewStep());
	
	if(skip) {
		skip = false;	//reset in case user goes back
		return "confirm";
	}
	else {
		return event.getNewStep();
	}
}





	List<Zona> zonaPrivato;


	public List<Zona> getZonaPrivato() {
		  zonaPrivato = new ArrayList();
		  zonaPrivato = entityManager.createQuery("Select n from Zona as n").getResultList();
		return zonaPrivato;
	}

	public void setZonaPrivato(List<Zona> zonaPrivato) {
		this.zonaPrivato = zonaPrivato;
	}

   
	
	
	
}
	 

