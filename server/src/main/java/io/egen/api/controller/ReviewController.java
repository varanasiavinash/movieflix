package io.egen.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import io.egen.api.entity.Review;
import io.egen.api.service.ReviewService;


@RestController
@RequestMapping(value = "reviews")
public class ReviewController {

	@Autowired
	private ReviewService service;
	
	//To view the comments and ratings by users on a title
	@RequestMapping(method = RequestMethod.GET, value = "{movieid}")
	public List<Review> findByMovie(@PathVariable("movieid") String movieid) {
		return service.findByMovie(movieid);
	}

	//To view the average ratings on a title
	@RequestMapping(method = RequestMethod.GET, value = "avgRating/{movieid}")
	public double findAvgRatingByMovie(@PathVariable("movieid") String movieid) {
		return service.findAvgRatingByMovie(movieid);
	}
	
	//To write a comment and rating on a title
	@RequestMapping(method = RequestMethod.POST)
	public Review create(@RequestBody Review review) {
		return service.create(review);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public Review update(@RequestBody Review review) {
		return service.update(review);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	public void delete(@PathVariable("id") String id) {
		service.delete(id);
	}
}
