package tn.esprit.nids.labo.recherche.persistence;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Contrat   implements Serializable {
	
	
	private int id ;
	private float salaire ;
	private TypeContrat typecontrat ;
	private Employe employe;
	
	
	@Id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public float getSalaire() {
		return salaire;
	}
	public void setSalaire(float salaire) {
		this.salaire = salaire;
	}
	@Enumerated(EnumType.STRING) 
	public TypeContrat getTypecontrat() {
		return typecontrat;
	}
	public void setTypecontrat(TypeContrat typecontrat) {
		this.typecontrat = typecontrat;
	}
	@OneToOne(mappedBy="contrat")
	public Employe getEmploye() {
		return employe;
	}
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((employe == null) ? 0 : employe.hashCode());
		result = prime * result + id;
		result = prime * result + Float.floatToIntBits(salaire);
		result = prime * result + ((typecontrat == null) ? 0 : typecontrat.hashCode());
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
		Contrat other = (Contrat) obj;
		if (employe == null) {
			if (other.employe != null)
				return false;
		} else if (!employe.equals(other.employe))
			return false;
		if (id != other.id)
			return false;
		if (Float.floatToIntBits(salaire) != Float.floatToIntBits(other.salaire))
			return false;
		if (typecontrat != other.typecontrat)
			return false;
		return true;
	}
	
	


}
