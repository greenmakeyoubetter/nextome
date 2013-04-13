package com.mydomain.pkg.action;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.persistence.EntityManager;
import org.jboss.seam.Component;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Transactional;
import org.jboss.seam.annotations.faces.Validator;
import org.jboss.seam.annotations.intercept.BypassInterceptors;



@Name("mailValidator")
@Validator
@BypassInterceptors
@Transactional
public class MailValidator implements javax.faces.validator.Validator, Serializable{

	
	

      public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {         
	        
		 
		     String email = (String) value;   
	        if(!email.contains("@")) {
		    throw new ValidatorException(new FacesMessage("Recapito mail non valido!"));
	        }
	   
	        if(!email.contains(".")) {
		   throw new ValidatorException(new FacesMessage("Recapito mail non valido!"));
	        }
	 
	        List<String> tmplList = new ArrayList();

	        EntityManager entityManager = (EntityManager) Component.getInstance("entityManager");
	        tmplList = entityManager.createQuery("Select n.mailUtente from Utente as n where n.mailUtente = :param1").setParameter("param1", email).getResultList();


	        if(tmplList.size()>0) {

	       	   throw new ValidatorException(new FacesMessage("Recapito mail gia in uso!"));
	       		
	             }
	   
	
	   
	    } 
	   
	   
	   
	   
	   
	   
	   
	  
	    


	
}