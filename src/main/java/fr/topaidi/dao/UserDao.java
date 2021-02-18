package fr.topaidi.dao;

import java.util.Optional;

import com.sun.org.apache.xpath.internal.operations.Bool;

import fr.topaidi.entite.Users;

public interface UserDao {

	void addUser(Users user);

	boolean verifUser(String email, String pass);

	boolean verifEmailUser(String email);

	Users getUser(int id);

}
