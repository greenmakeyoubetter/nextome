package com.mydomain.pkg.action;
import java.util.Date;
import java.util.List;

import javax.ejb.Local;
import javax.faces.event.ActionEvent;

import org.brickred.socialauth.AuthProvider;
import org.brickred.socialauth.SocialAuthManager;
import org.primefaces.event.FlowEvent;

import com.mydomain.pkg.model.Zona;

public interface RegistrazioneManagerInterface {
	public void remove();
	public void cercaZona();
    public Zona getZonaRegistrazione(); 
    public void setZonaRegistrazione(Zona zonaRegistrazione);
	public String getZonaString();
	public void setZonaString(String zonaString);
	public List<String> getCapString();
	public void setCapString(List<String> capString);
	public String salvaUtente(); 
	public void cercaZonaString();
	public List<Zona> getListZona();
	public void setListZona(List<Zona> listZona);
	public List<Zona> autocomplete(Object suggest);
	public byte[] getUploadedFile();
	public void setUploadedFile(byte[] uploadedFile);
	public String getPictureName();
	public void setPictureName(String pictureName);
	public String getContentType();
	public void setContentType(String contentType);
	public String getConfermaPass();
	public void setConfermaPass(String confermaPass);
	public List<Zona> getZonaSede();
	public List<Zona> autocompleteSede(Object suggest);
	public String getZonaString2();
	public void setZonaString2(String zonaString2);
	public boolean isReg();
	public void setReg(boolean reg);
	public void dummy();
	public String salvaUtenteAzienda();
	public boolean isSkip();
	public void setSkip(boolean skip);
	public String onFlowProcess(FlowEvent event);
	public List<Zona> getZonaPrivato();
	public void setZonaPrivato(List<Zona> zonaPrivato);
	


	
}
