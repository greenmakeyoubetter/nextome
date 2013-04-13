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



@Name("capValidator")
@Validator
@BypassInterceptors
@Transactional
public class CapValidator implements javax.faces.validator.Validator, Serializable{
	

	    @Override	
	    public void validate(FacesContext context, UIComponent component, Object value)
	            throws ValidatorException {         
	        String capo = (String) value;
            EntityManager entityManager = (EntityManager) Component.getInstance("entityManager");
	     	List<String> xy = new ArrayList();
			xy  =  entityManager.createQuery("Select n.capZona from Zona as n where n.capZona = :param1").setParameter("param1", capo).getResultList();
		   if( xy.size()== 0 ) {
			   throw new ValidatorException(new FacesMessage("Cap errato!"));
	         }
	   
	   
	    }
	


	
}