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
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.brickred.socialauth.AuthProvider;
import org.brickred.socialauth.Contact;
import org.brickred.socialauth.Profile;
import org.brickred.socialauth.SocialAuthConfig;
import org.brickred.socialauth.SocialAuthManager;
import org.brickred.socialauth.util.SocialAuthUtil;
import org.jboss.seam.Component;
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

import com.mydomain.pkg.model.ProfiloSocial;
import com.mydomain.pkg.model.Social;
import com.mydomain.pkg.model.Utente;


@Stateful
//@Scope(ScopeType.CONVERSATION)
@Name("socialProfile")
public class SocialProfile implements SocialProfileInterface{
	
	
	@Logger
	Log log;
		
		
	@In
	EntityManager entityManager;//
	
	@In(required=false)
	@Out(required=false)
	AuthProvider provider;//
	
	@In(required=false)
	@Out(required=false)
	Profile profile;
	
	@In(required=false)
	@Out(required=false)
	Utente utente;//

	@In
	FacesMessages facesMessages;//
	
	@In(required=false)
	@Out(required=false)
	ProfiloSocial prSocial;
		
	@In
    Credentials credentials;

	
	@In(required=false)
	@Out(required=false)
	List<ContactList> listContact;
	  
	
		 public String profileName;
		 
		 public String cognomeSocial;
		 
		 public String displaySocial;
		 
		 public String countrySocial;

		 public String imageSocial;
		 
		 public String mailFb;
		 
		 public String mailer;
		 
		 public boolean acc ;
		
         public String nomeFB;
		
         public int amici;
         
         public String fullName;
         
         

			public String getFullName() {
			return fullName;
		}

		public void setFullName(String fullName) {
			this.fullName = fullName;
		}

			public String getNomeFB() {
			return nomeFB;
		}

		public void setNomeFB(String nomeFB) {
			this.nomeFB = nomeFB;
		}

			public String getMailer() {
				return mailer;
			}

			public void setMailer(String mailer) {
				this.mailer = mailer;
			}
			
			
			public String getMailFb() {
				return mailFb;
			}

			public void setMailFb(String mailFb) {
				this.mailFb = mailFb;
			}
			 
		 
		 
		 public void setProfileName(String profileName) {
		     this.profileName = profileName;
		 }

		public String getCognomeSocial() {
			return cognomeSocial;
		}

		public void setCognomeSocial(String cognomeSocial) {
			this.cognomeSocial = cognomeSocial;
		}

		public String getDisplaySocial() {
			return displaySocial;
		}

		public void setDisplaySocial(String displaySocial) {
			this.displaySocial = displaySocial;
		}

		public String getCountrySocial() {
			return countrySocial;
		}

		public void setCountrySocial(String countrySocial) {
			this.countrySocial = countrySocial;
		}

		public String getImageSocial() {
			return imageSocial;
		}

		public void setImageSocial(String imageSocial) {
			this.imageSocial = imageSocial;
		}

		public boolean isAcc() {
			return acc;
		}

		public void setAcc(boolean acc) {
			this.acc = acc;
		}
		
		


		 public int getAmici() {
			return amici;
		}

		public void setAmici(int amici) {
			this.amici = amici;
		}

		public String getProfileName() throws Exception  {

			    try {
			 
			    ExternalContext ectx = FacesContext.getCurrentInstance().getExternalContext();
		        HttpServletRequest request = (HttpServletRequest)ectx.getRequest();
		        HttpSession session = request.getSession(true);
		        SocialAuthManager m = (SocialAuthManager)session.getAttribute("authManager"); 
		   
		        
		        
		     //   session = request.getSession();
            
                
		        provider = m.connect(SocialAuthUtil.getRequestParametersMap(request));
		      
		         
		       if(provider.getProviderId()!=null){  
		    	   Conversation.instance().begin(true,false);    
		    	   profile = provider.getUserProfile();
				     
			         log.info("provider.getProviderId() ***************************** "+provider.getProviderId());
			         log.info("profile ***************************** "+profile.getProviderId());

		    	   
		    	   
		    	   
		    	   
		         if (provider.getProviderId().equals("facebook")){
		        	 
		        	  Profile p = provider.getUserProfile();
		        	    
			             String userName=p.getFirstName(); 
			             
			             utente = new Utente();
		        	     utente.setNomePrivato(userName);
			             
			             
			             setNomeFB(p.getFirstName());
			             setMailFb(p.getEmail());
			             setProfileName(p.getFirstName());
			             setCognomeSocial(p.getLastName());
			             setCountrySocial(p.getCountry());
			             setImageSocial(p.getProfileImageURL());
			             int k = provider.getContactList().size();
			             setFullName("*");
			             setDisplaySocial("*");
			             List<Contact> cont = provider.getContactList();
			             
			             listContact = new ArrayList();
			         	 int i=0;
			         	    for (i=0;i<k-1;i++){	    	
			         	    	Contact  st =  cont.get(i);
			               //     String image = "http://graph.facebook.com/"+st.getId()+"/picture";
			         	    	listContact.add(new ContactList(st.getFirstName(), st.getLastName() , st.getEmail(), "http://graph.facebook.com/"+st.getId()+"/picture"));
			         	    }

			             setAmici(k);
			             credentials.setUsername(p.getEmail());
		        	 
		        	 
		        	 
		        	 
		            Social fb = new Social();
		            fb = (Social) entityManager.createQuery("Select n from Social as n where n.nomeSocial = :param1").setParameter("param1", "FACEBOOK").getSingleResult();
		            List<Utente> controllox = new ArrayList();
		            controllox = entityManager.createQuery("Select n from Utente as n where n.mailUtente = :param1").setParameter("param1", p.getEmail()).getResultList();
		            if(controllox.size()==1){
		        	 List<ProfiloSocial> controlloy = new ArrayList();
		        	 controlloy = entityManager.createQuery("Select n from ProfiloSocial as n where n.socialProfilo = :param1 and n.utenteSocial = :param2").setParameter("param1", fb).setParameter("param2", controllox.get(0)).getResultList();
		        	 acc = true;
		        	 if(controlloy.size()==0){
		        		 prSocial = new ProfiloSocial();
		        		 prSocial.setSocialProfilo(fb);
		        		 prSocial.setUtenteSocial(controllox.get(0));
		        		 prSocial.setImmagineSocial(p.getProfileImageURL());
		        		 prSocial.setIdSocialProfilo(p.getValidatedId());
		        		 entityManager.persist(prSocial); 
		        	 }
		        	 if(controlloy.size()==1){
		        		 prSocial = new ProfiloSocial();
		        		 prSocial = controlloy.get(0);
		        		 if(prSocial.getIdSocialProfilo()==null)
		        		 {
		        			 prSocial.setImmagineSocial(p.getProfileImageURL());
		        			 prSocial.setIdSocialProfilo( p.getValidatedId());
		        			 entityManager.flush();
		        		 }
		        		 
		        	 }
		
		            credentials.setUsername(p.getEmail());
		            log.info(" con p != null  mail da facebook "+getMailFb());
		            log.info(" con p != null  credentials"+credentials.getUsername());
		            log.info("acccesso == "+acc);
				     
		         }
		         
		         if(controllox.size()==0){
		        	 log.info("non account");
		        	 utente = new Utente();
		        //	 utente.setImgUtente(p.getProfileImageURL());
		        	 utente.setMailUtente(getMailFb());
		        	 acc = false;
		         }
		         return userName;}
		         if (provider.getProviderId().equals("twitter")){
		        	 
		        	     Profile p = provider.getUserProfile();
		        	     String userName= "*" ;    
			             setNomeFB("*");
			             setMailFb("*");
			             setProfileName("*");
			             setCognomeSocial("*");
			             setDisplaySocial(p.getDisplayName());
			             setCountrySocial(p.getLanguage());
			             setFullName("*");
			             setImageSocial(p.getProfileImageURL()); 
			             int k = provider.getContactList().size();
			             List<Contact> cont = provider.getContactList();
			             listContact = new ArrayList();
			         	 int i=0;
			         	    for (i=0;i<k-1;i++){
			         	    	
			         	    	Contact  st =  cont.get(i);
			               //     String image = "http://graph.facebook.com/"+st.getId()+"/picture";
			         	    	listContact.add(new ContactList(st.getFirstName(), st.getLastName() , st.getEmail(), "http://graph.facebook.com/"+st.getId()+"/picture"));
			         	    }
			             setAmici(k);
			             /*
			           credentials.setUsername(p.getEmail());  
			           Social tw = new Social();
			            tw = (Social) entityManager.createQuery("Select n from Social as n where n.nomeSocial = :param1").setParameter("param1", "TWITTER").getSingleResult();
			            List<Utente> controllox = new ArrayList();
			            controllox = entityManager.createQuery("Select n from Utente as n where n.mailUtente = :param1").setParameter("param1", p.getEmail()).getResultList();
			            if(controllox.size()==1){
			        	 List<ProfiloSocial> controlloy = new ArrayList();
			        	 controlloy = entityManager.createQuery("Select n from ProfiloSocial as n where n.socialProfilo = :param1 and n.utenteSocial = :param2").setParameter("param1", tw).setParameter("param2", controllox.get(0)).getResultList();
			        	 acc = true;
			        	 if(controlloy.size()==0){
			        		 prSocial = new ProfiloSocial();
			        		 prSocial.setSocialProfilo(tw);
			        		 prSocial.setUtenteSocial(controllox.get(0));
			        		 prSocial.setImmagineSocial(p.getProfileImageURL());
			        		 prSocial.setIdSocialProfilo(p.getValidatedId());
			        		 entityManager.persist(prSocial); 
			        	 }
			        	 if(controlloy.size()==1){
			        		 prSocial = new ProfiloSocial();
			        		 prSocial = controlloy.get(0);
			        		 if(prSocial.getIdSocialProfilo()==null)
			        		 {
			        			 prSocial.setImmagineSocial(p.getProfileImageURL());
			        			 prSocial.setIdSocialProfilo( p.getValidatedId());
			        			 entityManager.flush();
			        		 }
			        		 
			        	 }
			
			            credentials.setUsername(p.getEmail());
			            log.info(" con p != null  mail da facebook "+getMailFb());
			            log.info(" con p != null  credentials"+credentials.getUsername());
			            log.info("acccesso == "+acc);
					     
			         }
			         
			         if(controllox.size()==0){
			        	 log.info("non account");
			        	 utente = new Utente();
			        //	 utente.setImgUtente(p.getProfileImageURL());
			        	 utente.setMailUtente(getMailFb());
			        	 acc = false;
			         }
			         */
			         return userName;}
		         
		         if (provider.getProviderId().equals("google")){
		        	  Profile p = provider.getUserProfile();
			             String userName=p.getFirstName();    
			             setNomeFB(p.getFirstName());
			             setMailFb(p.getEmail());
			             setProfileName(p.getFirstName());
			             setCognomeSocial(p.getLastName());
			             setDisplaySocial( p.getDisplayName());
			             setCountrySocial(p.getCountry());
			             setImageSocial(p.getProfileImageURL());
			             setFullName(p.getFullName());
			             int k = provider.getContactList().size();
			             List<Contact> cont = provider.getContactList();
			             
			             listContact = new ArrayList();
			         	 int i=0;
			         	    for (i=0;i<k-1;i++){
			         	    	
			         	    	Contact  st =  cont.get(i);
			               //     String image = "http://graph.facebook.com/"+st.getId()+"/picture";
			         	    	listContact.add(new ContactList(st.getFirstName(), st.getLastName() , st.getEmail(), "http://graph.facebook.com/"+st.getId()+"/picture"));
			         	    }
			             
			             setAmici(k);
			             credentials.setUsername(p.getEmail());
			            Social go = new Social();
			            go = (Social) entityManager.createQuery("Select n from Social as n where n.nomeSocial = :param1").setParameter("param1", "TWITTER").getSingleResult();
			            List<Utente> controllox = new ArrayList();
			            controllox = entityManager.createQuery("Select n from Utente as n where n.mailUtente = :param1").setParameter("param1", p.getEmail()).getResultList();
			            if(controllox.size()==1){
			        	 List<ProfiloSocial> controlloy = new ArrayList();
			        	 controlloy = entityManager.createQuery("Select n from ProfiloSocial as n where n.socialProfilo = :param1 and n.utenteSocial = :param2").setParameter("param1", go).setParameter("param2", controllox.get(0)).getResultList();
			        	 acc = true;
			        	 if(controlloy.size()==0){
			        		 prSocial = new ProfiloSocial();
			        		 prSocial.setSocialProfilo(go);
			        		 prSocial.setUtenteSocial(controllox.get(0));
			        		 prSocial.setImmagineSocial(p.getProfileImageURL());
			        		 prSocial.setIdSocialProfilo(p.getValidatedId());
			        		 entityManager.persist(prSocial); 
			        	 }
			        	 if(controlloy.size()==1){
			        		 prSocial = new ProfiloSocial();
			        		 prSocial = controlloy.get(0);
			        		 if(prSocial.getIdSocialProfilo()==null)
			        		 {
			        			 prSocial.setImmagineSocial(p.getProfileImageURL());
			        			 prSocial.setIdSocialProfilo( p.getValidatedId());
			        			 entityManager.flush();
			        		 }
			        		 
			        	 }
			
			            credentials.setUsername(p.getEmail());
			            log.info(" con p != null  mail da facebook "+getMailFb());
			            log.info(" con p != null  credentials"+credentials.getUsername());
			            log.info("acccesso == "+acc);
					     
			         }
			         
			         if(controllox.size()==0){
			        	 log.info("non account");
			        	 utente = new Utente();
			        //	 utente.setImgUtente(p.getProfileImageURL());
			        	 utente.setMailUtente(getMailFb());
			        	 acc = false;
			         }
			         return userName;}		            
		    //   m.disconnectProvider("facebook");
		     return "";
		       }       
		        
			    }
			    
			    catch (Exception e) {
					// TODO Auto-generated catch block
			    	 log.info("catch TUTTO  *");
			         acc = false;
			    	 setMailFb("*");
		             setMailer("*");
		             setProfileName("*");
		             setCognomeSocial("*");
		             setDisplaySocial("*");
		             setCountrySocial("*");
		             setImageSocial("*");
		             setNomeFB("*");
		             setFullName("*");
			    	 return "*";
				}
		          
			    
				    log.info(" FUORI DAL catch TUTTO  *");
			         acc = false;
		             setMailFb("*");
		             setMailer("*");
		             setProfileName("*");
		             setCognomeSocial("*");
		             setDisplaySocial("*");
		             setCountrySocial("*");
		             setImageSocial("*");
		             setFullName("*");
		             setNomeFB("*");
	                 return "*";
		 }
		
		
		
		
		
			/* ANCILLARY METHODS */	
			@Remove
			@Destroy
			public void remove() {}
		
		
		
		
		
		
}

	 
	 
	 
	 
	 

