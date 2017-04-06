package tn.esprit.nids.labo.recherche.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.nids.labo.recherche.persistence.Employe;
import tn.esprit.nids.labo.recherche.persistence.Projet;
@Remote
public interface GererProjetServiceRemote {

	
	
	List<Projet> ListerEmploye ();

}
