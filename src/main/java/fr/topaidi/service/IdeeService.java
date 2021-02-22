package fr.topaidi.service;

import java.util.List;

import fr.topaidi.entite.Idea;

public interface IdeeService {
	
	Idea getIdee(Long id);	
	List<Idea> getListIdee();
	List<Idea> getIdeeClassement();
	
}
