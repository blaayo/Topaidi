package fr.topaidi.dao;

import java.util.List;

import fr.topaidi.entite.Commentaires;

public interface CommentaireDao {
	
	List<Commentaires> getCommentsByIdea(Long IdIdea);

}
