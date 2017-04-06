package tn.esprit.nids.labo.recherche.services;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;

import tn.esprit.nids.labo.recherche.persistence.*;

@Local
public interface GererLaboServiceLabo {
	
	
	void creerLabo(Labo labo);
	void supprimer(Labo labo);
	void modifier(Labo labo);
	void affecterEmployeLabo(Employe emp ,Labo labo);
	Labo chercherLaboById(int id);
	List<Labo> listLabo();

}
