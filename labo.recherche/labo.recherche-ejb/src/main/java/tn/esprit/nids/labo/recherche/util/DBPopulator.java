package tn.esprit.nids.labo.recherche.util;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import tn.esprit.nids.labo.recherche.persistence.Chercheur;
import tn.esprit.nids.labo.recherche.persistence.Employe;
import tn.esprit.nids.labo.recherche.persistence.Todo;
import tn.esprit.nids.labo.recherche.services.GererEmployeeServiceLocal;
import tn.esprit.nids.labo.recherche.services.TodoServiceLocal;

@Singleton
@Startup
public class DBPopulator {

	@EJB
	private TodoServiceLocal todoServiceLocal;
	@EJB
	GererEmployeeServiceLocal employeeServiceLocal;

	public DBPopulator() {
	}

	@PostConstruct
	public void init() {
		Employe employe = new Employe();
		employe.setCin("012345");
		employe.setNom("foulen");
		employe.setPrenom("foulen");
		employeeServiceLocal.creerEmployee(employe);
//		Chercheur chercheur = new Chercheur();
//		chercheur.setCin("123");
//		chercheur.setLogin("chercheur");
//		chercheur.setPassword("chercheur");
//		Date date = new Date(1987, 12, 20);
//		chercheur.setDateNaissace(date);
//		employeeServiceLocal.creerEmployee(chercheur);
	}
}
