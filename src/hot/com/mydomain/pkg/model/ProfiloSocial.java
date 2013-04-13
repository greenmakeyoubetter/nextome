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
import org.jboss.seam.annotations.Scope;

import javax.persistence.Column;
import javax.persistence.Table;

@Entity
@Scope(org.jboss.seam.ScopeType.SESSION)
@Name(value = "profiloSocial")
@Table(name = "25_social_profili")
public class ProfiloSocial implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_social_25")
	private Long socialProfiloId;		// PK counter
	
	@ManyToOne
	@JoinColumn(name = "utente_social_25")
	private Utente utenteSocial;
	
	@ManyToOne
	@JoinColumn(name = "social_25")
	private Social socialProfilo;
	
	@Column(name = "id_social_profile_25")
	private String idSocialProfilo;
	
	@Column(name = "img_social_25")
	private String immagineSocial;
	
	
	
	
	

	public Long getSocialProfiloId() {
		return socialProfiloId;
	}

	public void setSocialProfiloId(Long socialProfiloId) {
		this.socialProfiloId = socialProfiloId;
	}

	public Utente getUtenteSocial() {
		return utenteSocial;
	}

	public void setUtenteSocial(Utente utenteSocial) {
		this.utenteSocial = utenteSocial;
	}

	public Social getSocialProfilo() {
		return socialProfilo;
	}

	public void setSocialProfilo(Social socialProfilo) {
		this.socialProfilo = socialProfilo;
	}

	public String getIdSocialProfilo() {
		return idSocialProfilo;
	}

	public void setIdSocialProfilo(String idSocialProfilo) {
		this.idSocialProfilo = idSocialProfilo;
	}

	public String getImmagineSocial() {
		return immagineSocial;
	}

	public void setImmagineSocial(String immagineSocial) {
		this.immagineSocial = immagineSocial;
	}

	public ProfiloSocial() {
	}

  @Override
    public boolean equals(Object other) {
        if (other == null || !(other instanceof ProfiloSocial)) {
            return false;
        }
        ProfiloSocial otherProfiloSocial = (ProfiloSocial) other;
        return (getSocialProfiloId() == otherProfiloSocial.getSocialProfiloId());
    }

    @Override
    public int hashCode() {
        int intId = (int)(getSocialProfiloId()/1000);
    	return 37*intId + 97;
    }
}
