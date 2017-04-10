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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((domain == null) ? 0 : domain.hashCode());
		result = prime * result + ((projet_chercheur == null) ? 0 : projet_chercheur.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Chercheur other = (Chercheur) obj;
		if (domain == null) {
			if (other.domain != null)
				return false;
		} else if (!domain.equals(other.domain))
			return false;
		if (projet_chercheur == null) {
			if (other.projet_chercheur != null)
				return false;
		} else if (!projet_chercheur.equals(other.projet_chercheur))
			return false;
		return true;
	}
	

	
	
	
	
	
}
