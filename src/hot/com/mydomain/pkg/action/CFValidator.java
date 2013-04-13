package com.mydomain.pkg.action;

import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import org.jboss.seam.log.Log;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.faces.Validator;
import org.jboss.seam.annotations.intercept.BypassInterceptors;
import org.jboss.seam.contexts.Contexts;


@Name("cfValidator")
@Validator
@BypassInterceptors
public class CFValidator implements javax.faces.validator.Validator, Serializable{
	
	@Logger
	Log log;
	
	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object arg2) throws ValidatorException {
		
		String lunghezza = (String)arg2;
		log.info("*** Lunghezza CF/IVA: " +lunghezza.length()+ "***");
		if(lunghezza.length() != 16 ) {
throw new ValidatorException(new FacesMessage("Il Codice fiscale deve essere di 16 caratteri", null));
		}
		
		String in = (String)arg2;
	
			if(!controllaCF(in)) {
				throw new ValidatorException(new FacesMessage(" Il codice fiscale non e' corretto!"));
			
		}
		
	}


	private boolean controllaCF(String cf) {
		
		int i, s;
		String validi, set1, set2, setpari, setdisp, cf2;
		cf2 = cf.toUpperCase();
		validi = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		for( i=0; i<16; i++){
			if (validi.indexOf(cf2.charAt(i)) == -1 ){
				return false;
			}
		}
		set1 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		set2 = "ABCDEFGHIJABCDEFGHIJKLMNOPQRSTUVWXYZ";
		setpari = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		setdisp = "BAKPLCQDREVOSFTGUHMINJWZYX";
		s = 0;
		for(i=1; i<=13; i+=2) {
			s = s + setpari.indexOf(set2.charAt(set1.indexOf(cf2.charAt(i))));
		}
        for(i=0; i<=14; i+=2) {
        	s = s + setdisp.indexOf(set2.charAt(set1.indexOf(cf2.charAt(i))));
        }
//        if(s%26 != cf2.charCodeAt(15)-'A'.charCodeAt(0)){
        if(s%26 + 'A' != cf2.charAt(15)){
			return false;
        }
        return true;
        
	}
	
	private int parseInt(char charAt) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}