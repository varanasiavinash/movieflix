package io.egen.api.service;

import java.util.List;


import io.egen.api.entity.User;

public interface UserService {

	
	public List<User> findAll();

	public User findOne(String id);

	public User create(User user);
	
	public User login(String email, String password);

	public User update(String id, User user);

	public void delete(String id);
}
