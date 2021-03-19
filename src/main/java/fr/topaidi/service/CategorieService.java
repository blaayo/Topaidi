package fr.topaidi.service;

import java.util.List;

import fr.topaidi.entite.Category;


public interface CategorieService {

	void addCategories(Category categories);

	List<Category> getCategories();

}
