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

import org.hibernate.FlushMode;
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
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.FlowEvent;

import com.mydomain.pkg.model.Accesso;
import com.mydomain.pkg.model.CategoriaCondivisione;
import com.mydomain.pkg.model.Condivisione;
import com.mydomain.pkg.model.CondivisioneCategoria;
import com.mydomain.pkg.model.ProfiloSocial;
import com.mydomain.pkg.model.Social;
import com.mydomain.pkg.model.Utente;
import com.mydomain.pkg.model.Zona;


@Stateful
@Name("createManager")
public class CreateManager implements CreateManagerInterface{
	
	
	@Logger
	Log log;
		
		
	@In
	EntityManager entityManager;//
	
	
	@In
	FacesMessages facesMessages;//
	
		
	@In(required=false)
	@Out(required=false)
	Utente utente;

	@In(required=false)
	@Out(required=false)
	Condivisione condivisione;
	
	private byte[] uploadedFile;

	private String pictureName;	

	private String contentType;
		
		
	@Remove
	@Destroy
	public void remove() {}

	
public void salvaAttivita(ActionEvent actionEvent){
		
			
		try {
	 
	   
		entityManager.persist(condivisione);
	//	entityManager.flush();
		Conversation.instance().end();
	
	}
		catch(Exception e) {
			facesMessages = new FacesMessages();
			facesMessages.add("Si è verificato un errore, ti invitiamo a riprovare! Ci scusiamo per il disagio.");
			
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

@DataModel
List<CategoriaCondivisione> creatingAttivita;


@DataModelSelection
CategoriaCondivisione SelCreatingAttivita;

@Factory("creatingAttivita")
public void cercaCategorieAttivita(){
	log.info("inizializzo");
	Conversation.instance().begin(true,false);
	Conversation.instance().changeFlushMode(FlushModeType.MANUAL);
	creatingAttivita = new ArrayList<CategoriaCondivisione>();
	creatingAttivita = entityManager.createQuery("Select n from CategoriaCondivisione as n").getResultList();
	condivisione = new Condivisione();
}

public void aggiungiCategoria(){
	CondivisioneCategoria catCreating = new CondivisioneCategoria();
	catCreating.setCategoriaCondivisione(SelCreatingAttivita);
}



public void Chiudi(){
	condivisione = new Condivisione();
	Conversation.instance().end();
}
	


public void handleFileUpload(FileUploadEvent event) {
	log.info("fileupload");
		FacesMessage msg = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}












}














	

	 

