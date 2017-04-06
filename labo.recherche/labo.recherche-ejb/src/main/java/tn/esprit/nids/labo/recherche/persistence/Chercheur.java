package tn.esprit.nids.labo.recherche.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
//@DiscriminatorValue(value="c")
public class Chercheur extends Employe implements Serializable 
{

	private String domain ;
	private List<Intervention> projet_chercheur;

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}
	@OneToMany(mappedBy="chercheur")
	public List<Intervention> getProjet_chercheur() {
		return projet_chercheur;
	}

	public void setProjet_chercheur(List<Intervention> projet_chercheur) {
		this.projet_chercheur = projet_chercheur;
	}
	

	
	
	
	
	
}
