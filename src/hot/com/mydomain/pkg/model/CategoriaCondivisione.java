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
@Name(value = "categoriaCondivisione")
@Table(name = "9_categorie_condivisione")
public class CategoriaCondivisione implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_categoria_9")
	private Long categoriaId;		// PK counter
		
	@Column(name = "nome_categoria_9")
	private String nomeCategoria;
	
	@Column(name = "descrizione_categoria_9")
	private String descrizioneCategoria;
	
	@Column(name = "ico_categoria_9")
	private String iconaCategoria;
	
	
	
	@ManyToOne
	@JoinColumn(name = "tema_categoria_9")
	private TemaCategoria temCategoria;

	public CategoriaCondivisione() {
	}
	
	

  public Long getCategoriaId() {
		return categoriaId;
	}

	public void setCategoriaId(Long categoriaId) {
		this.categoriaId = categoriaId;
	}


	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}

	public String getDescrizioneCategoria() {
		return descrizioneCategoria;
	}

	public void setDescrizioneCategoria(String descrizioneCategoria) {
		this.descrizioneCategoria = descrizioneCategoria;
	}

	public String getIconaCategoria() {
		return iconaCategoria;
	}

	public void setIconaCategoria(String iconaCategoria) {
		this.iconaCategoria = iconaCategoria;
	}

	

public TemaCategoria getTemCategoria() {
		return temCategoria;
	}



	public void setTemCategoria(TemaCategoria temCategoria) {
		this.temCategoria = temCategoria;
	}



@Override
    public boolean equals(Object other) {
        if (other == null || !(other instanceof CategoriaCondivisione)) {
            return false;
        }
        CategoriaCondivisione otherCategoriaCondivisione = (CategoriaCondivisione) other;
        return (getCategoriaId() == otherCategoriaCondivisione.getCategoriaId());
    }

    @Override
    public int hashCode() {
        int intId = (int)(getCategoriaId()/1000);
    	return 37*intId + 97;
    }
}
