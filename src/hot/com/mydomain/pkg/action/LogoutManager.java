package com.mydomain.pkg.action;

import it.elbuild.jcoord.LatLng;
import it.elbuild.jcoord.resolver.GeoCodeResolver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import static org.jboss.seam.ScopeType.SESSION;
import java.util.List;
import org.jboss.seam.contexts.Context;
import org.jboss.seam.contexts.Contexts;
import java.util.Map;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.faces.component.UIInput;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.awt.Color;
import java.io.File;
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
import org.jboss.seam.security.Identity;
import org.jboss.seam.web.Session;

import com.mydomain.pkg.model.ProfiloSocial;
import com.mydomain.pkg.model.Utente;



@Stateless
@Name("logoutManager")
public class LogoutManager implements LogoutManagerInterface{
	
	
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
	ProfiloSocial profiloSocial;
	 
    @In Identity identity;   
	
	 public void esci(){
	    	utente = new Utente();
	    	profiloSocial = new ProfiloSocial();
	    	identity.logout();
	    }
}
	
	
	
	


