package tn.esprit.nids.labo.recherche.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.nids.labo.recherche.persistence.Employe;
import tn.esprit.nids.labo.recherche.persistence.Labo;
import tn.esprit.nids.labo.recherche.persistence.Projet;

/**
 * Session Bean implementation class GererProjetService
 */
@Stateless

public class GererProjetService implements GererProjetServiceRemote {

    /**
     * Default constructor. 
     */
	
	@PersistenceContext
	EntityManager em;
	
    public GererProjetService() {
        // TODO Auto-generated constructor stub
    	
    	
    	
    }

	@Override
	public List<Projet> ListerEmploye() {
		// TODO Auto-generated method stub
		TypedQuery<Projet> query = em.createNamedQuery("ListerProjet",Projet.class);

		return query.getResultList();	
		
	}

}
