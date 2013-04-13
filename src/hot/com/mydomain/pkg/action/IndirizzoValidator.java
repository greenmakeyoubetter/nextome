package com.mydomain.pkg.action;

import it.elbuild.jcoord.LatLng;
import it.elbuild.jcoord.resolver.GeoCodeResolver;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.persistence.EntityManager;

import org.jboss.seam.log.Log;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.faces.Validator;
import org.jboss.seam.annotations.intercept.BypassInterceptors;

import com.mydomain.pkg.model.Utente;


@Name("indirizzoValidator")
@Validator
@BypassInterceptors
public class IndirizzoValidator implements javax.faces.validator.Validator, Serializable{
	
	@Logger
	Log log;
	
	
	@In
	EntityManager entityManager;
	
	
	
	    @Override	
	    public void validate(FacesContext context, UIComponent component, Object value)
	            throws ValidatorException {         
	        String indirizzo = (String) value;
	        String ind = indirizzo.toUpperCase();
	        log.info("indirizzo "+ind);
	       boolean c = ind.contains("VIA");
	       boolean a = ind.contains("CORSO");
	       boolean b = ind.contains("PIAZZA");
	       boolean d = ind.contains("VIALE") ;
	       boolean e = ind.contains("STRADA") ;
	       boolean f = ind.contains("VICOLO") ;
	       boolean g = ind.contains("VICOLETTO") ;
	       
	       
	       log.info("booleani a"+a);
	       log.info("booleani b"+b);
	       log.info("booleani c"+c);
	       log.info("booleani d"+d);
	       log.info("booleani e"+e);
	       log.info("booleani f"+f);
	       log.info("booleani g"+g);
	       
	       
	       
	        
	   if( (a==false) && (b==false) && (c==false) && (d==false) && (e==false) && (f==false) && (g==false) ) {
		   throw new ValidatorException(new FacesMessage("L' indirizzo sembra errato. Esempio: (via, corso, piazza, viale) Vittorio Veneto , 10 ."));
			
	        }
	  
	 
	    
	    
	  
	 
	   
	   
	   
	    }
	


	
}