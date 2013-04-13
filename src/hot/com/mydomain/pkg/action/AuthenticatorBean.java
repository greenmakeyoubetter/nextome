package com.mydomain.pkg.action;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import org.brickred.socialauth.AuthProvider;
import org.brickred.socialauth.Profile;
import org.jboss.seam.annotations.FlushModeType;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;
import org.jboss.seam.core.Conversation;
import org.jboss.seam.faces.FacesMessages;
import org.jboss.seam.log.Log;
import org.jboss.seam.security.Credentials;
import org.jboss.seam.security.Identity;

import com.mydomain.pkg.model.Accesso;
import com.mydomain.pkg.model.ProfiloSocial;
import com.mydomain.pkg.model.Social;
import com.mydomain.pkg.model.Utente;
import org.jboss.seam.annotations.Begin;

@Stateless
@Name("authenticator")
public class AuthenticatorBean implements Authenticator
{
    @Logger private Log log;

    @In Identity identity;
    @In Credentials credentials;
    
    @In
	EntityManager entityManager;//
	
    @In(required=false)
	@Out(required=false)
	Utente utente;
    

	@In(required=false)
	@Out(required=false)
	ProfiloSocial profiloSocial;
	
	@In(required=false)
	@Out(required=false)
	AuthProvider provider;//
	
	@In(required=false)
	@Out(required=false)
	Profile profile;//
	
    
	@In
	FacesMessages facesMessages;//

//	@Begin(flushMode = FlushModeType.MANUAL)
    public boolean authenticate()
    {
    	
        String hashPasswordFornita = md5hash(credentials.getPassword());
        List<Accesso> tmpAccesso = new ArrayList();
        tmpAccesso =  entityManager.createQuery("Select n from Accesso as n where n.accessoSoggetto.mailUtente = :param1 and n.accessoSoggetto.passUtente = :param2 and n.dataDisattivazioneAccesso = null").setParameter("param1", credentials.getUsername()).setParameter("param2", hashPasswordFornita).getResultList();
     if(tmpAccesso.size()==1){
    	  Accesso acc =  tmpAccesso.get(0);
      //    Conversation.instance().begin();
      //    Conversation.instance().changeFlushMode(FlushModeType.MANUAL);
    	  utente = acc.getAccessoSoggetto();
          Social fb = new Social();
          fb = (Social) entityManager.createQuery("Select n from Social as n where n.nomeSocial = :param1").setParameter("param1", "FACEBOOK").getSingleResult();
     	  List<ProfiloSocial> tmpprofiliSocial = new ArrayList();
    	  tmpprofiliSocial =  entityManager.createQuery("Select n from ProfiloSocial as n where n.socialProfilo = :param1 and n.utenteSocial.mailUtente = :param2").setParameter("param1", fb).setParameter("param2", utente.getMailUtente()).getResultList();
   		  
      if(tmpprofiliSocial.size()==1){
	      profiloSocial = tmpprofiliSocial.get(0);
       }
      
    	  identity.addRole("admin");
    	 // credentials.setUsername(utente.getUsername());
    	  return true;
    	
      }  
      if(tmpAccesso.size()==0){
       	  return false;
      }  
      if(tmpAccesso.size()>1){
    	  return false;
      } 
       return false;
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
        }
        return hashString;
    }      
    
    
   
}
