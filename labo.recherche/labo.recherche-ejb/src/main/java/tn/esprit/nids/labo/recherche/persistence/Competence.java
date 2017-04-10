package tn.esprit.nids.labo.recherche.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
public class Competence implements Serializable {
	
	private int id ;
	
	private String nom ;
	
	private List<Ingenieur> Ingenieurs ;
	
	@Id
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	@ManyToMany(mappedBy="competences")
	public List<Ingenieur> getIngenieurs() {
		return Ingenieurs;
	}

	public void setIngenieurs(List<Ingenieur> ingenieurs) {
		Ingenieurs = ingenieurs;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Ingenieurs == null) ? 0 : Ingenieurs.hashCode());
		result = prime * result + id;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Competence other = (Competence) obj;
		if (Ingenieurs == null) {
			if (other.Ingenieurs != null)
				return false;
		} else if (!Ingenieurs.equals(other.Ingenieurs))
			return false;
		if (id != other.id)
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		return true;
	}
	
	
	
	

}
