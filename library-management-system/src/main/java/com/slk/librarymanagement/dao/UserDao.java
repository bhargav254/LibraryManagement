package com.slk.librarymanagement.dao;

import java.util.List;

import com.slk.librarymanagement.model.User;

public interface UserDao {

	User addUser(User user);
	
	List<User> getUsers();
	
	User updateUser(User user);
	
	boolean removeUser(User user);
}
