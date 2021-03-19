package fr.topaidi.dao;

import java.util.List;

import fr.topaidi.entite.Commentaires;
import fr.topaidi.entite.Idea;

public interface CommentaireDao {
	
	List<Commentaires> getCommentsByIdea(Idea IdIdea);

}
