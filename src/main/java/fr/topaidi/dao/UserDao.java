package fr.topaidi.dao;

import com.sun.org.apache.xpath.internal.operations.Bool;

import fr.topaidi.entite.Users;

public interface UserDao {

	void addUser(Users user);
	
	boolean verifUser(String email, String pass);

	Users getUser(int id);

}
