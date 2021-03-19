package fr.topaidi.dao;

import java.util.List;

import fr.topaidi.entite.Commentaires;
import fr.topaidi.entite.Idea;

public interface CommentaireDao {
	
	void addCommentaire(Commentaires comments);
	
	List<Commentaires> getCommentsByIdea(Idea IdIdea);

}
