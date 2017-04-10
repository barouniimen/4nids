package tn.esprit.nids.labo.recherche.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.nids.labo.recherche.persistence.*;

/**
 * Session Bean implementation class GererLaboService
 */
@Stateless
public class GererLaboService implements GererLaboServiceRemote, GererLaboServiceLabo {

	
	@PersistenceContext
	EntityManager em;

	@Override
	public void creerLabo(Labo labo) {
		em.persist(labo);
	}

	@Override
	public void supprimer(Labo labo) {

		em.remove(em.find(Labo.class,labo.getId()));
	}

	@Override
	public void modifier(Labo labo) {

		
		em.merge(labo);
	}

	@Override
	public void affecterEmployeLabo(Employe emp, Labo labo) {
		// TODO Auto-generated method stub
		emp =em.find(Employe.class,emp.getCin());
		emp.setLabo(labo);
	}

	@Override
	public Labo chercherLaboById(int id) {

		return	em.find(Labo.class,id);
		
	
	}

	@Override
	public List<Labo> listLabo() {
		// TODO Auto-generated method stub
		
		TypedQuery<Labo> query = em.createNamedQuery("Listerlabo",Labo.class);

		return query.getResultList();	
		
	}

	@Override
	public Labo chercherLaboParNom(String nom) {
		TypedQuery<Labo> query = em.createQuery("select l from Labo l where l.nom=:nom",Labo.class);
		query.setParameter("nom", nom);
		return query.getSingleResult();
	}
	
    /**
     * Default constructor. 
     */

}
