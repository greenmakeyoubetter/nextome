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
@Name(value = "temaCategoria")
@Table(name = "22_temi_categorie")
public class TemaCategoria implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tema_categoria_22")
	private Long temaCategoriaId;		// PK counter
		
	@Column(name = "nome_tema_22")
	private String nomeTemaCategoria;
	
	@Column(name = "img_tema_22")
	private String imgTemaCategoria;
	
	

	public String getImgTemaCategoria() {
		return imgTemaCategoria;
	}

	public void setImgTemaCategoria(String imgTemaCategoria) {
		this.imgTemaCategoria = imgTemaCategoria;
	}

	public Long getTemaCategoriaId() {
		return temaCategoriaId;
	}

	public void setTemaCategoriaId(Long temaCategoriaId) {
		this.temaCategoriaId = temaCategoriaId;
	}

	public String getNomeTemaCategoria() {
		return nomeTemaCategoria;
	}

	public void setNomeTemaCategoria(String nomeTemaCategoria) {
		this.nomeTemaCategoria = nomeTemaCategoria;
	}

	public TemaCategoria() {
	}

  @Override
    public boolean equals(Object other) {
        if (other == null || !(other instanceof TemaCategoria)) {
            return false;
        }
        TemaCategoria otherTemiCategorie = (TemaCategoria) other;
        return (getTemaCategoriaId() == otherTemiCategorie.getTemaCategoriaId());
    }

    @Override
    public int hashCode() {
        int intId = (int)(getTemaCategoriaId()/1000);
    	return 37*intId + 97;
    }
}
