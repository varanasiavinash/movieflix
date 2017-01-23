package io.egen.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import io.egen.api.entity.User;
import io.egen.api.exception.BadRequestException;
import io.egen.api.exception.EntityNotFoundException;
import io.egen.api.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	@Transactional(readOnly = true)
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public User findOne(String id) {
		User user = repository.findOne(id);
		if (user == null) {
			throw new EntityNotFoundException("User not found");
		}
		return user;
	}

	@Override
	@Transactional
	public User create(User user) {
		User existing = repository.findByEmail(user.getEmail());
		if (existing != null) {
			throw new BadRequestException("User with this email already exists");
		}
		String encryptPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encryptPassword);
		return repository.create(user);
	}

	@Override
	@Transactional
	public User update(String id, User user) {
		User existing = repository.findOne(id);
		if (existing == null) {
			throw new EntityNotFoundException("User not found");
		}
		return repository.update(user);
	}

	@Override
	@Transactional
	public void delete(String id) {
		User existing = repository.findOne(id);
		if (existing == null) {
			throw new EntityNotFoundException("User not found");
		}
		repository.delete(existing);
		
	}

	@Override
	@Transactional
	public User login(String email, String password) {
		
		User existing = repository.findByEmail(email);
		if (existing != null) {
			if(passwordEncoder.matches(password, existing.getPassword())) {
				return existing;
			}	else throw new EntityNotFoundException("User not found");
		} else throw new EntityNotFoundException("User not found");
	}

	
}
