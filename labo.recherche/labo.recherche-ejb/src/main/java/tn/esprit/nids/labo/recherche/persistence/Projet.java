package tn.esprit.nids.labo.recherche.persistence;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Projet
 *
 */
@Entity
@NamedQueries(
		{
			@NamedQuery(name="ListerProjet",query=" select p from Projet p ")
		})
public class Projet implements Serializable {

	
	private int id;
	private String nom;
	private String Description;
	private List<Intervention> projet_chercheur;

	private static final long serialVersionUID = 1L;

	public Projet() {
		super();
	}   
	@Id    
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}   
	public String getDescription() {
		return this.Description;
	}

	public void setDescription(String Description) {
		this.Description = Description;
	}
	@OneToMany(mappedBy="projets")
	public List<Intervention> getProjet_chercheur() {
		return projet_chercheur;
	}

	public void setProjet_chercheur(List<Intervention> projet_chercheur) {
		this.projet_chercheur = projet_chercheur;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Description == null) ? 0 : Description.hashCode());
		result = prime * result + id;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((projet_chercheur == null) ? 0 : projet_chercheur.hashCode());
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
		Projet other = (Projet) obj;
		if (Description == null) {
			if (other.Description != null)
				return false;
		} else if (!Description.equals(other.Description))
			return false;
		if (id != other.id)
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (projet_chercheur == null) {
			if (other.projet_chercheur != null)
				return false;
		} else if (!projet_chercheur.equals(other.projet_chercheur))
			return false;
		return true;
	}
   
}
