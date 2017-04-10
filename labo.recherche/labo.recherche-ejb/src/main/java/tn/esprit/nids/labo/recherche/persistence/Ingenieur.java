package tn.esprit.nids.labo.recherche.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

@Entity
//@DiscriminatorValue(value="i")

public class Ingenieur extends Employe  implements Serializable 
{
	
	private String diplome ;
	private List<Competence> Competences ;


	public String getDiplome() {
		return diplome;
	}

	public void setDiplome(String diplome) {
		this.diplome = diplome;
	}
	@ManyToMany
	public List<Competence> getCompetences() {
		return Competences;
	}

	public void setCompetences(List<Competence> competences) {
		Competences = competences;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((Competences == null) ? 0 : Competences.hashCode());
		result = prime * result + ((diplome == null) ? 0 : diplome.hashCode());
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
		Ingenieur other = (Ingenieur) obj;
		if (Competences == null) {
			if (other.Competences != null)
				return false;
		} else if (!Competences.equals(other.Competences))
			return false;
		if (diplome == null) {
			if (other.diplome != null)
				return false;
		} else if (!diplome.equals(other.diplome))
			return false;
		return true;
	}
	
	

}
