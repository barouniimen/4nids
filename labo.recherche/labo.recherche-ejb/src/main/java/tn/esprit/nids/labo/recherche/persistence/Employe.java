package tn.esprit.nids.labo.recherche.persistence;

import java.io.Serializable;

import javax.persistence.*;

@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@Entity
@Table(name="t_employe")//changer nomde la table
//@DiscriminatorColumn(name="type_de_donne")
@NamedQueries(
		{
			@NamedQuery(name="authentifier",query="select e from Employe e WHERE e.login=:login AND e.password=:password"),
			@NamedQuery(name="ListerEmploy",query="select e from Employe e ")
			
		
		
		
			})
public class Employe  implements Serializable  {
	
	private String cin;
	private String nom;
	private String prenom;
	private Contrat  contrat;
	private Labo labo ;
	private String login;
	private String password;
	
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Id
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	@Column(nullable=false) // thahra 
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	@Column(nullable=false,name="t_prenom")
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	@OneToOne(cascade=CascadeType.PERSIST) 
	public Contrat getContrat() {
		return contrat;
	}
	public void setContrat(Contrat contrat) {
		this.contrat = contrat;
	}
	@ManyToOne
	public Labo getLabo() {
		return labo;
	}
	public void setLabo(Labo labo) {
		this.labo = labo;
	}
	
	
	
	
	
	
	

}
