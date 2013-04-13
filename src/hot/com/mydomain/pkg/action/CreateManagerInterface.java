package com.mydomain.pkg.action;

import javax.faces.event.ActionEvent;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.FlowEvent;

public interface CreateManagerInterface {
	public void remove();
	public void salvaAttivita(ActionEvent actionEvent);
	public boolean isSkip();
	public void setSkip(boolean skip);
	public String onFlowProcess(FlowEvent event);
	public void cercaCategorieAttivita();
	public void aggiungiCategoria();
	public void Chiudi();
	public void handleFileUpload(FileUploadEvent event);
}
