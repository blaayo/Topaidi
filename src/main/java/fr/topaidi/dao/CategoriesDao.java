package fr.topaidi.dao;

import java.util.List;
import java.util.Optional;

import com.sun.org.apache.xpath.internal.operations.Bool;

import fr.topaidi.entite.Category;
import fr.topaidi.entite.Users;

public interface CategoriesDao {

	void addCategories(Category categories);

	List<Category> getCategories();


}
