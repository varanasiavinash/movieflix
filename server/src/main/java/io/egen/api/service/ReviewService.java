package io.egen.api.service;

import java.util.List;


import io.egen.api.entity.Review;



public interface ReviewService {

	
	public List<Review> findByMovie(String movieid);
	
	public Review create(Review review);
	
	public double findAvgRatingByMovie(String movieid);
	
	public Review update(Review review);

	public void delete(String id);
}


