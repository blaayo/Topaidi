package fr.topaidi.service;

import fr.topaidi.entite.Users;

public interface UserService {

	void addUser(Users user);
	
	boolean verifUser(String email, String pass);

	boolean verifEmailUser(String email);

	Users getUser(int id);

}
