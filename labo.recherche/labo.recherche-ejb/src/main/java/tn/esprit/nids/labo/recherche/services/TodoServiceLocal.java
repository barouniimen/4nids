package tn.esprit.nids.labo.recherche.services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.nids.labo.recherche.persistence.Todo;

@Local
public interface TodoServiceLocal {
	
	void create(Todo todo);
	List<Todo> findAll();

}
