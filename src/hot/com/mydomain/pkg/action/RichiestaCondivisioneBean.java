package com.mydomain.pkg.action;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;

import org.jboss.seam.annotations.Destroy;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;
import org.jboss.seam.faces.FacesMessages;
import org.jboss.seam.log.Log;
import org.richfaces.application.push.TopicKey;
import org.richfaces.application.push.TopicsContext;

import com.mydomain.pkg.model.RichiestaCondivisione;
import com.mydomain.pkg.model.Utente;

@Name("richiestaCondivisioneBean")
@Stateless
public class RichiestaCondivisioneBean implements Serializable{

	@Logger
	Log log;
			
	@In
	EntityManager entityManager;//
	
	@In
	FacesMessages facesMessages;//
	
	@In(required=false)
	Utente utente;
	
	public void search() {
	//	log.info("search");
		if(utente != null){
			Long count = (Long)  entityManager.createQuery("Select count(*) from RichiestaCondivisione as n where n.richiestaA = :param1 and n.dataVisualizzazione = null").setParameter("param1", utente).getSingleResult();
			//List<RichiestaCondivisione> tmplList = new ArrayList();
			//tmplList =  entityManager.createQuery("Select n from RichiestaCondivisione as n where n.richiestaA = :param1 and n.dataVisualizzazione = null").setParameter("param1", utente).getResultList();
		if(count>0){
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Ecco : "+count, " richieste per te!"));  
		}}
	}
	
}