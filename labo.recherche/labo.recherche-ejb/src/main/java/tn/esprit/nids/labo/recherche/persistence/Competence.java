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
	
	
	
	

}
