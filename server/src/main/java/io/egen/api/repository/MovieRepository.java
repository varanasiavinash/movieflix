package io.egen.api.repository;

import java.util.List;

import io.egen.api.entity.Movie;


public interface MovieRepository {

	public List<Movie> findAll();

	public Movie findOne(String id);
	
	public Movie findByTitle(String title);
	
	public List<Movie> findByType(String type);
	
	public List<Movie> findByYear(String year);
	
	public List<Movie> sortByCondition(String condition);
	
	public Movie create(Movie movie);

	public Movie update(Movie movie);

	public void delete(Movie movie);
	
}
