package io.egen.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.api.entity.Movie;
import io.egen.api.entity.User;
import io.egen.api.exception.AccessRestrictedException;
import io.egen.api.exception.BadRequestException;
import io.egen.api.exception.EntityNotFoundException;
import io.egen.api.repository.MovieRepository;
import io.egen.api.repository.UserRepository;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieRepository repository;

	@Autowired
	private UserRepository userrepository;

	public MovieServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	@Transactional(readOnly = true)
	public List<Movie> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Movie findOne(String id) {
		Movie movie = repository.findOne(id);
		if (movie == null) {
			throw new EntityNotFoundException("Movie not found");
		}
		return movie;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Movie> findByType(String type) {

		return repository.findByType(type);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Movie> findByYear(String year) {
		// TODO Auto-generated method stub
		return repository.findByYear(year);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Movie> sortByCondition(String condition) {
		// TODO Auto-generated method stub
		return repository.sortByCondition(condition);
	}

	@Override
	@Transactional
	public List<Movie> create(List<Movie> movieList, String userID) {
		List<Movie> list = new ArrayList<Movie>();
		User user = userrepository.findOne(userID);
		// System.out.println("user is "+user);
		if (user != null) {
			if (user.getType().equalsIgnoreCase("ADMIN")) {
				for (Movie movie : movieList) {
					Movie existing = repository.findByTitle(movie.getTitle());
					if (existing != null) {
						throw new BadRequestException("Movie with this title already exists");
					}
					list.add(repository.create(movie));
				}
				return list;
			} else
				throw new AccessRestrictedException("Only Admin can create/update/delete the movie");
		}
		return null;
	}

	@Override
	@Transactional
	public Movie update(String id, Movie movie, String userID) {
		User user = userrepository.findOne(userID);
		if (user != null) {
			if (user.getType().equalsIgnoreCase("ADMIN")) {
				Movie existing = repository.findOne(id);
				if (existing == null) {
					throw new EntityNotFoundException("Movie not found");
				}
				return repository.update(movie);
			} else
				throw new AccessRestrictedException("Only Admin can create/update/delete the movie");
		}
		return null;
	}

	@Override
	@Transactional
	public void delete(String id, String userID) {
		User user = userrepository.findOne(userID);
		if(user != null) {
		if (user.getType().equalsIgnoreCase("ADMIN")) {
			Movie existing = repository.findOne(id);
			if (existing == null) {
				throw new EntityNotFoundException("Movie not found");
			}

			repository.delete(existing);
		} else
			throw new AccessRestrictedException("Only Admin can create/update/delete the movie");

	}
	}

}
