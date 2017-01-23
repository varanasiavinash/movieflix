package io.egen.api.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.egen.api.entity.Movie;
import io.egen.api.service.MovieService;


@RestController
@RequestMapping(value = "movies")
public class MovieController {

	@Autowired
	private MovieService service;

	//To display all the movies
	@RequestMapping(method = RequestMethod.GET)
	public List<Movie> findAll() {
		return service.findAll();
	}

	//To view more details about the title
	@RequestMapping(method = RequestMethod.GET, value = "id/{id}")
	public Movie findOne(@PathVariable("id") String movieId) {
		return service.findOne(movieId);
	}
	
	//To filter the catalog based on type
	@RequestMapping(method = RequestMethod.GET, value = "type/{type}")
	public List<Movie> findByType(@PathVariable("type") String type) {
		return service.findByType(type);
	}
	
	//To filter the catalog based on year
	@RequestMapping(method = RequestMethod.GET, value = "year/{year}")
	public List<Movie> findByYear(@PathVariable("year") String year) {
		return service.findByYear(year);
	}
	
	//To sort the catalog by IMDB Ratings,Year,IMDB Votes and also to see Top Rated Movies and Series
	@RequestMapping(method = RequestMethod.GET, value = "sort/{condition}")
	public List<Movie> sortByCondition(@PathVariable("condition") String condition) {
		return service.sortByCondition(condition);
	}

	//To create/add a new title.Only admin can create the movies and it has to be sent through params when posting the request
	@RequestMapping(method = RequestMethod.POST)
	public List<Movie> create(@RequestBody List<Movie> movieList,HttpServletRequest request) {
		//System.out.println("user id is:   " +request.getParameter("userID"));
		return service.create(movieList,request.getParameter("userID"));
		
	}

	//To update a movie and again only admin can do it
	@RequestMapping(method = RequestMethod.PUT, value = "{id}")
	public Movie update(@PathVariable("id") String id, @RequestBody Movie movie, HttpServletRequest request) {
		return service.update(id, movie, request.getParameter("userID"));
	}

	//To delete a movie and again only admin can do it
	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	public void delete(@PathVariable("id") String id,  HttpServletRequest request) {
		service.delete(id, request.getParameter("userID") );
	}
}
