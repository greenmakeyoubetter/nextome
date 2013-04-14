package com.mydomain.pkg.action;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Date;

import javax.ejb.Local;

import org.brickred.socialauth.AuthProvider;
import org.brickred.socialauth.SocialAuthManager;

public interface SocialManagerInterface {
	public void remove();
	public void chiama();
	public String facebookAuthentication();
	public String twitterAuthentication();
    public void ipConfig();
	public void ipAddress() throws MalformedURLException, IOException;
	public void cercaAdress();
	public boolean isFbLogin();
	public void setFbLogin(boolean fbLogin);
	public void loginno();
	public String googleAuthentication();
}
