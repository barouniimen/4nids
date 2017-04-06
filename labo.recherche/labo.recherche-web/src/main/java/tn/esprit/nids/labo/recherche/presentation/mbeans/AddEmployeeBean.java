package tn.esprit.nids.labo.recherche.presentation.mbeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import tn.esprit.nids.labo.recherche.persistence.Contrat;
import tn.esprit.nids.labo.recherche.persistence.Employe;
import tn.esprit.nids.labo.recherche.persistence.Labo;
import tn.esprit.nids.labo.recherche.services.GererEmployeeServiceLocal;
import tn.esprit.nids.labo.recherche.services.GererLaboServiceLabo;

@ManagedBean
@RequestScoped
public class AddEmployeeBean {

	private String cin;
	private String nom;
	private String prenom;
	private String login;
	private String password;
	private int idContrat;
	private float salaire;
	private List<Labo> labos;
	private Labo laboSelectionne;

	@EJB
	GererLaboServiceLabo gererLaboServiceLocal;
	
	@EJB
	GererEmployeeServiceLocal employeeServiceLocal;

	@PostConstruct
	public void init(){
		labos= gererLaboServiceLocal.listLabo();
		laboSelectionne = new Labo();
		
	}
	
	public String ajouterEmploye() {
		Employe employe = new Employe();
		Contrat contrat = new Contrat();
		contrat.setId(idContrat);
		contrat.setSalaire(salaire);
		employe.setCin(cin);
		employe.setContrat(contrat);
		employe.setLogin(login);
		employe.setNom(nom);
		employe.setPassword(password);
		employe.setPrenom(prenom);
		System.out.println(laboSelectionne.getNom());
		employe.setLabo(laboSelectionne);
		employeeServiceLocal.creerEmployee(employe);
		return null;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

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

	public int getIdContrat() {
		return idContrat;
	}

	public void setIdContrat(int idContrat) {
		this.idContrat = idContrat;
	}

	public float getSalaire() {
		return salaire;
	}

	public void setSalaire(float salaire) {
		this.salaire = salaire;
	}

	public List<Labo> getLabos() {
		return labos;
	}

	public void setLabos(List<Labo> labos) {
		this.labos = labos;
	}

	public Labo getLaboSelectionne() {
		return laboSelectionne;
	}

	public void setLaboSelectionne(Labo laboSelectionne) {
		this.laboSelectionne = laboSelectionne;
	}

}
