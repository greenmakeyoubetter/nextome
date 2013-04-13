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
@Name(value = "condivisioneCategoria")
@Table(name = "27_categorie_condivisione")
public class CondivisioneCategoria implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_categorie_condivisione")
	private Long condivisioneCategoriaId;		// PK counter
		
	
	
	@ManyToOne
	@JoinColumn(name = "condivisione_27")
	private Condivisione condivisioneCategoria;

	@ManyToOne
	@JoinColumn(name = "categoria_27")
	private CategoriaCondivisione categoriaCondivisione;
	
	
	public CondivisioneCategoria() {
	}
	
	

public Long getCondivisioneCategoriaId() {
		return condivisioneCategoriaId;
	}



	public void setCondivisioneCategoriaId(Long condivisioneCategoriaId) {
		this.condivisioneCategoriaId = condivisioneCategoriaId;
	}



	public Condivisione getCondivisioneCategoria() {
		return condivisioneCategoria;
	}



	public void setCondivisioneCategoria(Condivisione condivisioneCategoria) {
		this.condivisioneCategoria = condivisioneCategoria;
	}



	public CategoriaCondivisione getCategoriaCondivisione() {
		return categoriaCondivisione;
	}



	public void setCategoriaCondivisione(CategoriaCondivisione categoriaCondivisione) {
		this.categoriaCondivisione = categoriaCondivisione;
	}



@Override
    public boolean equals(Object other) {
        if (other == null || !(other instanceof CondivisioneCategoria)) {
            return false;
        }
        CondivisioneCategoria otherCondivisioneCategoria = (CondivisioneCategoria) other;
        return (getCondivisioneCategoriaId() == otherCondivisioneCategoria.getCondivisioneCategoriaId());
    }

    @Override
    public int hashCode() {
        int intId = (int)(getCondivisioneCategoriaId()/1000);
    	return 37*intId + 97;
    }
}
