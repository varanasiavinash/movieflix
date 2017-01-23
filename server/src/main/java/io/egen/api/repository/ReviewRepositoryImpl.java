package io.egen.api.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import io.egen.api.entity.Review;



@Repository
public class ReviewRepositoryImpl implements ReviewRepository {

	@PersistenceContext
	private EntityManager em;
	
	public ReviewRepositoryImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Review> findByMovie(String movieid) {
		TypedQuery<Review> query = em.createNamedQuery("Comment.findByMovie", Review.class);
		query.setParameter("pID", movieid);
		return query.getResultList();
	}

	@Override
	public Review create(Review review) {
		em.persist(review);
		return review;
	}

	@Override
	public Review update(Review review) {
		// TODO Auto-generated method stub
		return em.merge(review);
	}

	@Override
	public void delete(Review review) {
		// TODO Auto-generated method stub
		em.remove(review);
	}

	@Override
	public Review findOne(String id) {
		// TODO Auto-generated method stub
		return em.find(Review.class, id);
	}

	@Override
	public double findAvgRatingByMovie(String movieid) {
		TypedQuery<Double> query = em.createNamedQuery("Comment.findAvgRating",Double.class);
		query.setParameter("pID", movieid);
		return (double)query.getSingleResult();
	}

}
