package io.egen.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import io.egen.api.entity.Review;
import io.egen.api.exception.EntityNotFoundException;
import io.egen.api.repository.ReviewRepository;



@Service
public class ReviewServiceImpl implements ReviewService {

	
	@Autowired
	private ReviewRepository repository;
	
	public ReviewServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	@Transactional
	public List<Review> findByMovie(String movieid) {
		// TODO Auto-generated method stub
		return repository.findByMovie(movieid);
	}

	@Override
	@Transactional
	public Review create(Review review) {
		// TODO Auto-generated method stub
		return repository.create(review);
	}

	@Override
	@Transactional
	public Review update(Review review) {
		// TODO Auto-generated method stub
		return repository.update(review);
	}

	@Override
	@Transactional
	public void delete(String id) {
		Review existing = repository.findOne(id);
		if (existing == null) {
			throw new EntityNotFoundException("Comment not found");
		}
		repository.delete(existing);
	}

	@Override
	@Transactional
	public double findAvgRatingByMovie(String movieid) {
		// TODO Auto-generated method stub
		return repository.findAvgRatingByMovie(movieid);
	}

}
