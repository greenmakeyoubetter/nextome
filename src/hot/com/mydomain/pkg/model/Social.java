package com.mydomain.pkg.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.jboss.seam.annotations.Name;

import javax.persistence.Column;
import javax.persistence.Table;

@Entity
@Name(value = "social")
@Table(name = "26_social")
public class Social implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_social_26")
	private Long socialId;		// PK counter
		
	@Column(name = "nome_social_26")
	private String nomeSocial;
	
	
	public Long getSocialId() {
		return socialId;
	}

	public void setSocialId(Long socialId) {
		this.socialId = socialId;
	}

	public String getNomeSocial() {
		return nomeSocial;
	}

	public void setNomeSocial(String nomeSocial) {
		this.nomeSocial = nomeSocial;
	}

	public Social() {
	}

  @Override
    public boolean equals(Object other) {
        if (other == null || !(other instanceof Social)) {
            return false;
        }
        Social otherSocial = (Social) other;
        return (getSocialId() == otherSocial.getSocialId());
    }

    @Override
    public int hashCode() {
        int intId = (int)(getSocialId()/1000);
    	return 37*intId + 97;
    }
}
