package fr.topaidi.service;

import java.util.List;

import fr.topaidi.entite.Commentaires;

public interface CommentaireService {
	
	void addCommentaire(Commentaires comments);

	List<Commentaires> getCommentsByIdea(Long IdIdea);
}
