package com.slk.librarymanagement.service;

import java.util.List;

import com.slk.librarymanagement.model.User;

public interface UserService {

	public User addUser(User user);
	
	public List<User> getUsers();
	
	public User updateUser(User user);
	
	public boolean removeUser(User user);
}
