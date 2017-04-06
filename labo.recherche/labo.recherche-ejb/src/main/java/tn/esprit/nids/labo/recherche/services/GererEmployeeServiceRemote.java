package tn.esprit.nids.labo.recherche.services;

import java.util.List;

import javax.ejb.Remote;


import tn.esprit.nids.labo.recherche.persistence.*;

@Remote
public interface GererEmployeeServiceRemote {
	
	void creerEmployee(Employe emp);
	void supprimerEmployee(Employe emp);
	void modifierEmployee(Employe emp);
	Employe chercherLaboEmployeeById(String cin);
	void affecterCompetenceIngenieur(Ingenieur ing, Competence comp);
	void affecterChercheurProjet(Chercheur cher, Projet projet,String DateDebut,String DateFin );
	Employe authentification(String login, String password );
	List<Employe> ListerEmploye ();
	
	

}
