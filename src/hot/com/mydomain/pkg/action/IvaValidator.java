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


@Name("ivaValidator")
@Validator
@BypassInterceptors
public class IvaValidator implements javax.faces.validator.Validator, Serializable{
	
	@Logger
	Log log;
	
	
	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object arg2) throws ValidatorException {
		
		String lunghezza = (String)arg2;
		log.info("*** Lunghezza CF/IVA: " +lunghezza.length()+ "***");
		if(lunghezza.length() != 11 ) {
throw new ValidatorException(new FacesMessage("La partita iva deve essere di 11 caratteri", null));
		}
		
		String in = (String)arg2;
	if(!controllaIVA(in)) {
				throw new ValidatorException(new FacesMessage(" La partita IVA non e' corretta!"));
			}
		
		}
		
//	@SuppressWarnings("unchecked")
	private boolean controllaIVA(String cf) {

		int i, c, d, s;
		String piva;
		piva = cf.substring(5, 16);
		for(i=0; i<11; i++) {
			if(piva.charAt(i) < '0' || piva.charAt(i) > '9') {
				return false;
			}
		}
		s = 0;
		c = 0;
		d = 0;
		for(i=0; i<=9; i+=2) {
	        s = s + piva.charAt(i) - '0';
			log.info("***PARI I: " +i+ " S: " +s+ "***");
		}
		for(i=1; i<=9; i+=2) {
			c = c + 2*(piva.charAt(i) - '0');
			if((piva.charAt(i) - '0') >= 5) {
				d = d + 1;
			}
			log.info("***DISPARI I: " +i+ " C: " +c+ " D: " +d+ "***");
		}
		s = s + c + d;
		log.info("***FINALE C: " +c+ " D: " +d+ " S: " +s+ "***");
		log.info("***CARATTERE CONTROLLO: " +piva.charAt(10)+ "***");
		if((10 - s%10)%10 != (piva.charAt(10) - '0')) {
			return false;
		}
		return true;
	
	}

	private int parseInt(char charAt) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}