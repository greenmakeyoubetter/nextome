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
import org.jboss.seam.web.Session;



@Stateful
@Name("geoManager")
public class GeoManager implements GeoManagerInterface{
	
	
	@Logger
	Log log;
		
		
	@In
	EntityManager entityManager;//
	
	
	@In
	FacesMessages facesMessages;//
	
	
	 
	   
	/* ANCILLARY METHODS */	
	@Remove
	@Destroy
	public void remove() {}
	
	


	   public void ipConfig(){
		 //Get an instance of InetAddress for the local computer
		   InetAddress inetAddress;
		   String ipAddress = "";
		try {
			inetAddress = InetAddress.getLocalHost();
			ipAddress = inetAddress.getHostAddress();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		   //Get a string representation of the ip address
		 

		   //Print the ip address
		  facesMessages.add(ipAddress);
	   }
	   
	   
	   public void ipAddress() throws MalformedURLException, IOException {
		     /* URL myIP = new URL("http://api.externalip.net/ip/");
		      BufferedReader in = new BufferedReader(
		                           new InputStreamReader(myIP.openStream())
		                          );
		      facesMessages.add(in.readLine());
		    //  return in.readLine();
		      
		      
		      */
		      URL whatismyip = new URL("http://checkip.amazonaws.com");
		      BufferedReader in2 = new BufferedReader(new InputStreamReader(
		                      whatismyip.openStream()));

		      String ip = in2.readLine(); //you get the IP as a String
		      System.out.println(ip);
		      facesMessages.add(in2.readLine());
		      in2.close();
		     
		      
		    }
	   
	   public void cercaAdress(){
		   
		   
		   
		   
		   double lat1; double longit1; double lat2; double longit2;
		   
		
		   String provincia = "Torino";
		   String comune = "Torino";
		   String address = "Corso Inghilterra";
		   
		   String provinciaUser = "Torino";
		   String comuneUser = "Torino";
		   String addressUser = "Piazza Vittorio Veneto";
		    
		   // call the static method of JCooord
		   LatLng coord = GeoCodeResolver.findExactCoordForAddress(provincia, comune, address);
		   
		   LatLng coord2 = GeoCodeResolver.findExactCoordForAddress(provinciaUser, comuneUser, addressUser);
		   
		   // get coordinate as double values
		   BigDecimal latidude = coord.getLat();
		   BigDecimal longitude = coord.getLng();
		   
		   
		   BigDecimal latidudeUser = coord2.getLat();
		   BigDecimal longitudeUser = coord2.getLng();
		   
		   
		   
		   
		   lat1 = latidude.doubleValue()*Math.PI / 180;
		   longit1 = longitude.doubleValue()*Math.PI / 180;
		   
		   lat2 = latidudeUser.doubleValue()*Math.PI / 180;
		   longit2 = longitudeUser.doubleValue()*Math.PI / 180;
		   
		  /* 
		    double distance = 0;
	        
	        double dist_long = longit2 - longit1;
	        double dist_lat = lat2 - lat1;
	        
	        double pezzo1 = Math.cos(lat2)*Math.sin(dist_long);
	        double pezzo11 = pezzo1*pezzo1;
	        
	        double pezzo2 = Math.cos(lat1)*Math.sin(lat2)-Math.sin(lat1)*Math.cos(lat2)*Math.cos(dist_long);
	        double pezzo22 = pezzo2*pezzo2;
	        
	        double pezzo3 = Math.sin(lat1)*Math.sin(lat2)+Math.cos(lat1)*Math.cos(lat2)*Math.cos(dist_long);
	        
	        double pezzo4 = Math.atan((Math.sqrt(pezzo11+pezzo22))/pezzo3);
	        
	        distance = pezzo4*6372;
		   
		   facesMessages.add("coordinate 1  - - latitudine :"+latidude.toString()+" longitudine : "+longitude.toString());
		   facesMessages.add("coordinate 2  - - latitudine :"+latidudeUser.toString()+" longitudine : "+longitudeUser.toString());
		   facesMessages.add("distanza : "+Double.toString(distance));
		   
		   */
		    double  PI     =  3.141592654;
		    double  lat1k  =  lat1;
		    double  lon1k  =  longit1;
		    double  lat2k  =  lat2;
		    double  lon2k  =  longit2;

		  // Dist = 6371.0090667 * ACos(Cos(lat1) * Cos(lat2) * Cos(lon2 - lon1) + Sin(lat1) * Sin(lat2))
		   
		   double Dist = 6371.0090667 * Math.acos(Math.cos(lat1k) * Math.cos(lat2k) * Math.cos(lon2k - lon1k) + Math.sin(lat1k) * Math.sin(lat2k));
			 
		   facesMessages.add("distanza : "+Double.toString(Dist));
		   
		   
		   
		   
	   }
	   
	   
	   
	  

	 
	   public void decode(FacesContext context) {
		   Map<String,String> params =  context.getExternalContext().getRequestParameterMap();
			  String action = params.get("action");
			  setCenter(action);
	   }
	   
	   
	   
	   public String center;
	   public String center2;




	public String getCenter() {
		
		
		setCenter("36.885233");
		
		return center;
	}


	


	public void setCenter(String center) {
		this.center = center;
	}




	public String getCenter2() {
		setCenter2("30.702323");
		return center2;
	}




	public void setCenter2(String center2) {
		this.center2 = center2;
	}
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   

}
	
	
	
	


