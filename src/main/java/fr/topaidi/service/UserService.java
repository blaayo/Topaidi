package fr.topaidi.service;

import com.sun.org.apache.xpath.internal.operations.Bool;

import fr.topaidi.entite.Users;

public interface UserService {

	void addUser(Users user);
	
	boolean verifUser(String email, String pass);

	Users getUser(int id);

}
