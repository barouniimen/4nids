package tn.esprit.nids.labo.recherche.persistence;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: projet_chercheur
 *
 */
@Entity
public class Intervention implements Serializable {

	
	private String DateDebut;
	private String DateFin;
	private projet_chercheur_FK FK;
	private Chercheur chercheur;
	private Projet projets;

	private static final long serialVersionUID = 1L;

	public Intervention() {
		super();
	}   
	public String getDateDebut() {
		return this.DateDebut;
	}

	public void setDateDebut(String DateDebut) {
		this.DateDebut = DateDebut;
	}   
	public String getDateFin() {
		return this.DateFin;
	}

	public void setDateFin(String DateFin) {
		this.DateFin = DateFin;
	}
	@EmbeddedId
	public projet_chercheur_FK getFK() {
		return FK;
	}
	public void setFK(projet_chercheur_FK fK) {
		FK = fK;
	}
	@ManyToOne
	@JoinColumn(name="chercheur_id",insertable=false,updatable=false)
	public Chercheur getChercheur() {
		return chercheur;
	}
	public void setChercheur(Chercheur chercheur) {
		this.chercheur = chercheur;
	}
	@ManyToOne
	@JoinColumn(name="projet_id",insertable=false,updatable=false)
	public Projet getProjets() {
		return projets;
	}
	public void setProjets(Projet projets) {
		this.projets = projets;
	}
	
}
