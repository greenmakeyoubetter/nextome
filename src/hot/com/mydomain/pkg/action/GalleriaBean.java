package com.mydomain.pkg.action;


import java.io.IOException;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.text.SimpleDateFormat;

import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.Destroy;
import org.jboss.seam.annotations.FlushModeType;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Observer;
import org.jboss.seam.annotations.Out;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.annotations.Transactional;
import org.jboss.seam.annotations.async.Asynchronous;
import org.jboss.seam.annotations.async.Expiration;
import org.jboss.seam.annotations.async.FinalExpiration;
import org.jboss.seam.annotations.async.IntervalDuration;
import org.jboss.seam.async.QuartzTriggerHandle;
import org.jboss.seam.core.Conversation;
import org.jboss.seam.log.Log;




import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;

import java.sql.Connection;
import java.sql.SQLException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

@Name("galleriaBean")
public class GalleriaBean {

    private List<String> images;

 
    @PostConstruct
    public void init() {
        images = new ArrayList<String>();

        for(int i=1;i<=3;i++) {
            images.add("Torino" + i + ".jpg");
        }
    }

 
public GalleriaBean(){}
   
    public List<String> getImages() {
        return images;
    }

    
}
             