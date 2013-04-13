package com.mydomain.pkg.action;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import org.jboss.seam.log.Log;
import org.jboss.seam.security.Identity;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.faces.Validator;
import org.jboss.seam.annotations.intercept.BypassInterceptors;
import org.jboss.seam.contexts.Contexts;

import com.mydomain.pkg.model.Utente;


@Name("passValidator")
@Validator
@BypassInterceptors
public class PassValidator implements javax.faces.validator.Validator, Serializable{
	
	@Logger
	Log log;
	
 //   @In Utente utente ;
	
	
	    @Override	
	    public void validate(FacesContext context, UIComponent component, Object value)
	            throws ValidatorException {         
	    	String conf = (String) value;
	   
	     UIInput uiInputPassword = (UIInput) component.findComponent("pass"); 
	   
	     String password2 = uiInputPassword.getLocalValue() == null ? ""
	    		   	: uiInputPassword.getLocalValue().toString();
	    	    	
	    	log.info("password 2 : "+password2);
	    	log.info("conf  : "+conf);
	    	boolean c = password2.equals(conf);
	    	boolean d = password2 == conf;
	    	log.info("c : "+c);
	    	log.info("d : "+d);
	    	
	// if(password2!=null){
	        if(!conf.equals(password2)) {
		   throw new ValidatorException(new FacesMessage("Le password devono coincidere!"));
			
	        }
	 //   }
	// else {
	//	 throw new ValidatorException(new FacesMessage("Inserire prima la password!"));
			
	// }
	 
	    }


	
}