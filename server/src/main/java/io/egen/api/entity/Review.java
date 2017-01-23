package io.egen.api.entity;

import java.sql.Timestamp;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


@Entity
@NamedQueries({ @NamedQuery(name = "Comment.findByMovie", query = "SELECT c FROM Review c WHERE c.movieID=:pID ORDER BY c.date"),
@NamedQuery(name = "Comment.findAvgRating", query = "SELECT AVG(c.rating) FROM Review c WHERE c.movieID=:pID")})
public class Review {

	
	@Id
	private String reviewID;
	
	private String userID;
	private String movieID;
	private String review;
	private double rating;
	
	private Timestamp date;
	
	
	public Review() {
		this.reviewID = UUID.randomUUID().toString();
	}
	
	
	public String getReviewID() {
		return reviewID;
	}


	public void setReviewID(String reviewID) {
		this.reviewID = reviewID;
	}


	public double getRating() {
		return rating;
	}


	public void setRating(double rating) {
		this.rating = rating;
	}


	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getMovieID() {
		return movieID;
	}
	public void setMovieID(String movieID) {
		this.movieID = movieID;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
		
	

}
