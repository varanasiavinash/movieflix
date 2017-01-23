package io.egen.api.repository;

import java.util.List;
import io.egen.api.entity.Review;


public interface ReviewRepository {

	
	public List<Review> findByMovie(String movieid);
	
	public Review findOne(String id);
	
	public Review create(Review review);
		
	public double findAvgRatingByMovie(String movieid);
	
	public Review update(Review review);

	public void delete(Review review);
}
