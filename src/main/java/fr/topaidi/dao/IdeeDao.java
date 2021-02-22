package fr.topaidi.dao;

import java.util.List;

import fr.topaidi.entite.Idea;

public interface IdeeDao {
	
	Idea getIdee(Long id);	
	List<Idea> getListIdee();
	List<Idea> getIdeeClassement();
	
}
