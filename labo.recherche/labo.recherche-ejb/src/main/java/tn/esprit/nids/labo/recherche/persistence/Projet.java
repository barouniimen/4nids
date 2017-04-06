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
   
}
