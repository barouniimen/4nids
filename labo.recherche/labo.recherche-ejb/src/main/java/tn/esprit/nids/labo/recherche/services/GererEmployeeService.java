package tn.esprit.nids.labo.recherche.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.nids.labo.recherche.persistence.*;

@Stateless
public class GererEmployeeService implements GererEmployeeServiceRemote, GererEmployeeServiceLocal {
	@PersistenceContext
	EntityManager em;

	@Override
	public void creerEmployee(Employe emp) {
		
		em.persist(emp);
	}

	@Override
	public void supprimerEmployee(Employe emp) {
		// TODO Auto-generated method stub
		em.remove(em.find(Employe.class, emp.getCin()));
	}

	@Override
	public void modifierEmployee(Employe emp) {
		// TODO Auto-generated method stub
		em.merge(emp);
	}

	@Override
	public Employe chercherLaboEmployeeById(String cin) {
		// TODO Auto-generated method stub
		return em.find(Employe.class, cin);
	}

	@Override
	public void affecterCompetenceIngenieur(Ingenieur ing, Competence comp) {
		// TODO Auto-generated method stub

		ing = em.find(Ingenieur.class, ing.getCin());
		List<Competence> lComp = ing.getCompetences();
		lComp.add(comp);
		ing.setCompetences(lComp);

	}

	@Override
	public void affecterChercheurProjet(Chercheur cher, Projet projet, String DateDebut, String DateFin) {
		// TODO Auto-generated method stub
		projet_chercheur_FK pk = new projet_chercheur_FK();
		pk.setChercheur_id(cher.getCin());
		pk.setProjet_id(projet.getId());

		Intervention intervention = new Intervention();
		intervention.setDateDebut(DateDebut);
		intervention.setDateFin(DateFin);
		intervention.setChercheur(cher);
		intervention.setProjets(projet);
		intervention.setFK(pk);

		em.persist(intervention);
	}

	@Override
	public Employe authentification(String login, String password) {
		// TODO Auto-generated method stub
		// Utilisation des jpql(java persistance query language)
		/*
		 * TypedQuery<Employe> query = em .createQuery(
		 * "SELECT e FROM Employe e " + "WHERE e.login=:login " +
		 * "and e.password=:password" ,Employe.class);
		 */
		TypedQuery<Employe> query = em.createNamedQuery("authentifier", Employe.class);

		query.setParameter("login", login);
		query.setParameter("password", password);
		try {
			return query.getSingleResult();
		} catch (Exception exception) {
			return null;
		}
	}

	@Override
	public List<Employe> ListerEmploye() {
		// TODO Auto-generated method stub
		TypedQuery<Employe> query = em.createNamedQuery("ListerEmploy", Employe.class);

		return query.getResultList();

	}

}
