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
	
	

}
