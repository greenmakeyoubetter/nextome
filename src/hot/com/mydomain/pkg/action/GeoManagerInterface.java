package com.mydomain.pkg.action;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Date;

import javax.ejb.Local;

import org.brickred.socialauth.AuthProvider;
import org.brickred.socialauth.SocialAuthManager;

public interface GeoManagerInterface {
	public void remove();
    public void ipConfig();
	public void ipAddress() throws MalformedURLException, IOException;
	public void cercaAdress();
	public String getCenter() ;
	public void setCenter(String center);
	public String getCenter2();
	public void setCenter2(String center2);
}
