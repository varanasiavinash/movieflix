package io.egen.api.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({ @NamedQuery(name = "Movie.findAll", query = "SELECT m FROM Movie m"),
		@NamedQuery(name = "Movie.findByTitle", query = "SELECT m FROM Movie m WHERE m.title=:ptitle"),
		@NamedQuery(name = "Movie.findByType", query = "SELECT m FROM Movie m WHERE m.type=:ptype"),
		@NamedQuery(name = "Movie.findByYear", query = "SELECT m FROM Movie m WHERE m.year=:pyear"),
		@NamedQuery(name = "Movie.sortByImdbRating", query = "SELECT m FROM Movie m ORDER BY m.imdbRating"),
		@NamedQuery(name = "Movie.sortByYear", query = "SELECT m FROM Movie m ORDER BY m.year"),
		@NamedQuery(name = "Movie.sortByImdbVotes", query = "SELECT m FROM Movie m ORDER BY m.imdbVotes"),
		@NamedQuery(name = "Movie.TopRatedMovies", query = "SELECT m FROM Movie m WHERE m.type='movie' ORDER BY m.imdbRating DESC"),
		@NamedQuery(name = "Movie.TopRatedSeries", query = "SELECT m FROM Movie m WHERE m.type='series' ORDER BY m.imdbRating DESC")})
public class Movie {

	@Id
	private String movieid;

	@Column(unique = true)
	private String title;

	private String type;
	private int year;
	private String rated;
	private String released;
	private String runtime;
	private String genre;
	private String director;
	
	@Lob
	private String writer;
	
	@Lob
	private String actors;

	@Lob
	private String plot;

	private String language;
	private String country;
	private String awards;
	private String poster;
	private double metaScore;
	private double imdbRating;
	private long imdbVotes;
	private String imdbId;
	
	@OneToMany
	private List<Review> reviews;

	public Movie() {
		this.movieid = UUID.randomUUID().toString();
		reviews = new ArrayList<Review>();
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public double getMetaScore() {
		return metaScore;
	}

	public void setMetaScore(double metaScore) {
		this.metaScore = metaScore;
	}

	public double getImdbRating() {
		return imdbRating;
	}

	public void setImdbRating(double imdbRating) {
		this.imdbRating = imdbRating;
	}

	public long getImdbVotes() {
		return imdbVotes;
	}

	public void setImdbVotes(long imdbVotes) {
		this.imdbVotes = imdbVotes;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRated() {
		return rated;
	}

	public void setRated(String rated) {
		this.rated = rated;
	}

	public String getReleased() {
		return released;
	}

	public void setReleased(String released) {
		this.released = released;
	}

	public String getRuntime() {
		return runtime;
	}

	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getActors() {
		return actors;
	}

	public void setActors(String actors) {
		this.actors = actors;
	}

	public String getPlot() {
		return plot;
	}

	public void setPlot(String plot) {
		this.plot = plot;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAwards() {
		return awards;
	}

	public void setAwards(String awards) {
		this.awards = awards;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String getMovieid() {
		return movieid;
	}

	public void setMovieid(String movieid) {
		this.movieid = movieid;
	}

	public String getImdbId() {
		return imdbId;
	}

	public void setImdbId(String imdbId) {
		this.imdbId = imdbId;
	}

}
