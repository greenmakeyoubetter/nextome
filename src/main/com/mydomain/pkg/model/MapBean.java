package com.mydomain.pkg.model;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;


import org.jboss.seam.annotations.Name;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

@Name("mapBean")
@ViewScoped
public class MapBean implements Serializable {

		
	/**
	 * 
	 */
	
	//private Marker mark ;
	 private  MapModel simpleModel;

	public MapBean() {}
	
	
	
	@PostConstruct
	public void initIt() throws Exception {
		 System.out.println("Init method after properties are set ");
	
		 
		simpleModel = new DefaultMapModel();
		 
	
		 
		//Shared coordinates
		LatLng coord1 = new LatLng(36.879466, 30.667648);
		LatLng coord2 = new LatLng(36.883707, 30.689216);
		LatLng coord3 = new LatLng(36.879703, 30.706707);
		LatLng coord4 = new LatLng(36.885233, 30.702323);
		
	
	    simpleModel.addOverlay(new Marker(coord1, "Konyaalti"));
		simpleModel.addOverlay(new Marker(coord2, "Ataturk Parki"));
		simpleModel.addOverlay(new Marker(coord3, "Karaalioglu Parki"));
		simpleModel.addOverlay(new Marker(coord4, "Kaleici"));

	
	  System.out.println("end method after properties are set ");
	}



	public MapModel getSimpleModel() {
		return simpleModel;
	}



	
	

}
			