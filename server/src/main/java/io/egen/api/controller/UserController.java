package io.egen.api.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import io.egen.api.entity.User;
import io.egen.api.exception.EntityNotFoundException;
import io.egen.api.service.UserService;

@RestController
@RequestMapping(value = "users")
public class UserController {

	@Autowired
	private UserService service;

	@RequestMapping(method = RequestMethod.GET)
	public List<User> findAll() {
		return service.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public User findOne(@PathVariable("id") String userId) {
		return service.findOne(userId);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "{email}/{password}")
	public ResponseEntity<?> login(@PathVariable("email") String email, @PathVariable("password") String password) {
		try{
			return new ResponseEntity<>(service.login(email,password), HttpStatus.OK);
			}
		catch(EntityNotFoundException e){
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	

	@RequestMapping(method = RequestMethod.POST)
	public User create(@RequestBody User user) {
		return service.create(user);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "{id}")
	public User update(@PathVariable("id") String id, @RequestBody User user) {
		return service.update(id, user);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	public void delete(@PathVariable("id") String id) {
		service.delete(id);
	}
}
