package com.supinfo.supcooking.dao;

import java.util.List;

import com.supinfo.supcooking.entity.User;

public interface UserDAO {
	
	// Définition des méthodes de l'interface
	void addUser(User aUser);
	User findUserById(Long id);
	List<User> getAllUsers();
	void updateUser(User aUser);
	void removeUser(User aUser);
}
