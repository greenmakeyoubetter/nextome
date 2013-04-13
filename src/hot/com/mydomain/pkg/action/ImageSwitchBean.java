package com.mydomain.pkg.action;
import java.util.ArrayList;  
import java.util.List; 
import org.jboss.seam.annotations.Name;

@Name("imageSwitchBean")
public class ImageSwitchBean {

    private List<String> images;

    public ImageSwitchBean() {
        images = new ArrayList<String>();
        images.add("Torino1.jpg");
        images.add("Torino2.jpg");
        images.add("Torino3.jpg");
    }

    public List<String> getImages() {
        return images;
    }
}
          