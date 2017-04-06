package tn.esprit.nids.labo.recherche.services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.nids.labo.recherche.persistence.Chercheur;
import tn.esprit.nids.labo.recherche.persistence.Competence;
import tn.esprit.nids.labo.recherche.persistence.Employe;
import tn.esprit.nids.labo.recherche.persistence.Ingenieur;
import tn.esprit.nids.labo.recherche.persistence.Projet;

@Local
public interface GererEmployeeServiceLocal {
	
	void creerEmployee(Employe emp);
	void supprimerEmployee(Employe emp);
	void modifierEmployee(Employe emp);
	Employe chercherLaboEmployeeById(String cin);
	void affecterCompetenceIngenieur(Ingenieur ing, Competence comp);
	void affecterChercheurProjet(Chercheur cher, Projet projet,String DateDebut,String DateFin );
	Employe authentification(String login, String password );
	List<Employe> ListerEmploye ();
	
	

}
