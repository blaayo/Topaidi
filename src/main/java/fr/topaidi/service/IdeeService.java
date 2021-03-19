package fr.topaidi.service;

import java.util.List;

import fr.topaidi.entite.Commentaires;
import fr.topaidi.entite.Idea;

public interface IdeeService {
	
	Idea getIdee(Long id);
	//List<Commentaires> getIdeaComments(Long id);
	List<Idea> getListIdee();
	List<Idea> getIdeeClassement();
	
	void AddIdee(Idea idee);
	
}
