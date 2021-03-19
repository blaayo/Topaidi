package fr.topaidi.dao;

import java.util.List;

import fr.topaidi.entite.Commentaires;
import fr.topaidi.entite.Idea;
import fr.topaidi.entite.Users;

public interface IdeeDao {
	
	
	void AddIdee(Idea idee);
	Idea getIdee(Long id);	
	//List<Commentaires> getIdeaComments(Long id);
	List<Idea> getListIdee();
	List<Idea> getIdeeClassement();
	
}
