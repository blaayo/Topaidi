package fr.topaidi.dao;

import java.util.List;
import java.util.Optional;

import com.sun.org.apache.xpath.internal.operations.Bool;

import fr.topaidi.entite.Users;

public interface UserDao {

	void addUser(Users user);

	List<Users> getUserByEmailPass(String email, String pass);

	List<Users> getUserByEmail(String email);

	Users getUser(int id);

}
