package com.mydomain.pkg.action;
import java.util.Date;

import javax.ejb.Local;

import org.brickred.socialauth.AuthProvider;
import org.brickred.socialauth.SocialAuthManager;

public interface SocialProfileInterface {
	public void remove();
	
	public String getCognomeSocial();
	public void setCognomeSocial(String cognomeSocial);
	public String getDisplaySocial();
	public void setDisplaySocial(String displaySocial);
	public String getCountrySocial() ;
	public void setCountrySocial(String countrySocial);
	public String getImageSocial();
	public void setImageSocial(String imageSocial);
	public boolean isAcc();
	public void setAcc(boolean acc);
	public String getMailFb();
	public void setMailFb(String mailFb);
	public String getMailer();
	public void setMailer(String mailer);
	public String getProfileName() throws Exception ;
	public void setProfileName(String profileName);
	public String getNomeFB();
	public void setNomeFB(String nomeFB);
	public int getAmici();
	public void setAmici(int amici);
	public String getFullName();
	public void setFullName(String fullName);
}
