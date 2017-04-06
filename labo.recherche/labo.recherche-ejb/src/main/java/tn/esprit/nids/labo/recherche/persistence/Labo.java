package tn.esprit.nids.labo.recherche.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@NamedQueries(
		{
			@NamedQuery(name="Listerlabo",query=" select l from Labo l ")
		})
public class Labo  implements Serializable {

	
	private int id;
	private String nom;
	private Adresse adresse;
	private List<Employe> employes;
	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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
	@OneToMany(mappedBy="labo",fetch=FetchType.EAGER,cascade=CascadeType.REMOVE)
	public List<Employe> getEmployes() {
		return employes;
	}
	public void setEmployes(List<Employe> employes) {
		this.employes = employes;
	}
	@Embedded
	public Adresse getAdresse() {
		return adresse;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	
	
	
	
	
}
