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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((DateDebut == null) ? 0 : DateDebut.hashCode());
		result = prime * result + ((DateFin == null) ? 0 : DateFin.hashCode());
		result = prime * result + ((FK == null) ? 0 : FK.hashCode());
		result = prime * result + ((chercheur == null) ? 0 : chercheur.hashCode());
		result = prime * result + ((projets == null) ? 0 : projets.hashCode());
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
		Intervention other = (Intervention) obj;
		if (DateDebut == null) {
			if (other.DateDebut != null)
				return false;
		} else if (!DateDebut.equals(other.DateDebut))
			return false;
		if (DateFin == null) {
			if (other.DateFin != null)
				return false;
		} else if (!DateFin.equals(other.DateFin))
			return false;
		if (FK == null) {
			if (other.FK != null)
				return false;
		} else if (!FK.equals(other.FK))
			return false;
		if (chercheur == null) {
			if (other.chercheur != null)
				return false;
		} else if (!chercheur.equals(other.chercheur))
			return false;
		if (projets == null) {
			if (other.projets != null)
				return false;
		} else if (!projets.equals(other.projets))
			return false;
		return true;
	}
	
}
