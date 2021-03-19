package fr.topaidi.service;

import java.util.List;

import fr.topaidi.entite.Users;

public interface UserService {

	void addUser(Users user);

	List<Users> getUserByEmailPass(String email, String pass);

	List<Users> getUserByEmail(String email);

	Users getUser(int id);

}
