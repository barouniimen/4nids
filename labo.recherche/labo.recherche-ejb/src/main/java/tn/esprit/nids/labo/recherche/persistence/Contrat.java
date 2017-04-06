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
	
	


}
