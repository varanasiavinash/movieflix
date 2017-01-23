package io.egen.api.service;

import java.util.List;

import io.egen.api.entity.Movie;


public interface MovieService {

	
	public List<Movie> findAll();

	public Movie findOne(String id);
	
	public List<Movie> findByType(String type);
	
	public List<Movie> findByYear(String year);
	
	public List<Movie> sortByCondition(String condition);

	public List<Movie> create(List<Movie> movieList, String userID);

	public Movie update(String id, Movie movie, String userID);

	public void delete(String id, String userID);
}
