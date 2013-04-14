package com.mydomain.pkg.action;

import it.elbuild.jcoord.LatLng;
import it.elbuild.jcoord.resolver.GeoCodeResolver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import static org.jboss.seam.ScopeType.SESSION;
import java.util.List;
import org.jboss.seam.contexts.Context;
import org.jboss.seam.contexts.Contexts;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
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
import org.jboss.seam.web.Session;

import com.mydomain.pkg.model.CategoriaCondivisione;
import com.mydomain.pkg.model.Condivisione;
import com.mydomain.pkg.model.DisponibilitaCondivisione;
import com.mydomain.pkg.model.TemaCategoria;
import com.mydomain.pkg.model.Utente;
import com.mydomain.pkg.model.Zona;

@Stateless
@Name("temiManager")
public class TemiManager implements Serializable{
	
@Logger
Log log;
			
@In
FacesMessages facesMessages;
	
@In(required=false)
Utente utente;
	
List<TemaCategoria> temaview;

List<CategoriaCondivisione> catview;

List<Condivisione> listCondivisione;

String searching;
  

@PostConstruct
public void initial(){
	//log.info("init");
	EntityManager entityManager = (EntityManager) Component.getInstance("entityManager");
	temaview = new ArrayList();
	catview = new ArrayList();
	temaview = entityManager.createQuery("Select n from TemaCategoria as n").getResultList();
	catview = entityManager.createQuery("Select n from CategoriaCondivisione as n").getResultList();
	listCondivisione = new ArrayList();
	if (utente!=null){
		listCondivisione = entityManager.createQuery("Select n from Condivisione as n where n.utenteCondivisione != :param1").setParameter("param1", utente).setMaxResults(20).getResultList();
}
	if (utente==null){
		listCondivisione = entityManager.createQuery("Select n from Condivisione as n").setMaxResults(20).getResultList();
	}
}


@PreDestroy
private void destroy() {
    System.out.println("In HelloBean(Stateless)::destroy()");
}

public void cercaString(){
	if(searching.equals("")){
	return;}
	
	if(!searching.equals("")){
		EntityManager entityManager = (EntityManager) Component.getInstance("entityManager");
		listCondivisione = new ArrayList();
		if (utente!=null){
			listCondivisione = entityManager.createQuery("Select n from Condivisione as n where n.utenteCondivisione != :param1 and ((n.descrizioneAttivita like :param2) or (n.descrizioneOggetto like :param2) or (n.descrizioneServizio like :param2))").setParameter("param1", utente).setParameter("param2", "%"+searching+"%").setMaxResults(20).getResultList();
	                     }
		if (utente==null){
			listCondivisione = entityManager.createQuery("Select n from Condivisione as n where (n.descrizioneAttivita like :param1) or (n.descrizioneOggetto like :param1) or (n.descrizioneServizio like :param1)").setParameter("param1", "%"+searching+"%").setMaxResults(20).getResultList();
		                  }
		                    }	
}

public void cercaCategorie(String c){
	log.info("la stringa della categoriaa*************************************************************************: "+c);
}

public List<TemaCategoria> getTemaview() {
	return temaview;
}

public void setTemaview(List<TemaCategoria> temaview) {
	this.temaview = temaview;
}

public List<CategoriaCondivisione> getCatview() {
	return catview;
}

public void setCatview(List<CategoriaCondivisione> catview) {
	this.catview = catview;
}

public List<Condivisione> getListCondivisione() {
	return listCondivisione;
}

public void setListCondivisione(List<Condivisione> listCondivisione) {
	this.listCondivisione = listCondivisione;
}

public String getSearching() {
	return searching;
}

public void setSearching(String searching) {
	this.searching = searching;
}


}
