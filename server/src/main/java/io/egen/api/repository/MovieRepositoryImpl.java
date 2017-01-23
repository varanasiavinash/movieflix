package io.egen.api.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import io.egen.api.entity.Movie;



@Repository
public class MovieRepositoryImpl implements MovieRepository{

	public MovieRepositoryImpl() {
		// TODO Auto-generated constructor stub
	}

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Movie> findAll() {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findAll", Movie.class);
		return query.getResultList();
	}

	@Override
	public Movie findOne(String id) {
		// TODO Auto-generated method stub
		return em.find(Movie.class, id);
	}
	
	@Override
	public List<Movie> findByType(String type) {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findByType", Movie.class);
		query.setParameter("ptype", type);
		return query.getResultList();
	}
	
	@Override
	public List<Movie> findByYear(String year) {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findByYear", Movie.class);
		query.setParameter("pyear", year);
		return query.getResultList();
	}
	
	@Override
	public List<Movie> sortByCondition(String condition) {
		String querySelect="";
		
		if(condition.equalsIgnoreCase("IMDBRATING")){
			querySelect = "Movie.sortByImdbRating";
		}else if(condition.equalsIgnoreCase("YEAR")){
			querySelect = "Movie.sortByYear";
		}else if (condition.equalsIgnoreCase("IMDBVOTES")){
			querySelect = "Movie.sortByImdbVotes";
		}else if (condition.equalsIgnoreCase("TOPRATEDMOVIES")){
			querySelect = "Movie.TopRatedMovies";
		}else if (condition.equalsIgnoreCase("TOPRATEDTVSERIES")){
			querySelect = "Movie.TopRatedSeries";
		}
		TypedQuery<Movie> query = em.createNamedQuery(querySelect, Movie.class);
		//System.out.println("The condition is :   "+querySelect);
		//System.out.println("The query is :   "+query.toString());
		return query.getResultList();
	}

	@Override
	public Movie findByTitle(String title) {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findByTitle", Movie.class);
		query.setParameter("ptitle", title);

		List<Movie> movies = query.getResultList();
		if (movies != null && movies.size() == 1) {
			return movies.get(0);
		} else {
			return null;
		}
	}

	@Override
	public Movie create(Movie movie) {
		em.persist(movie);
		return movie;
	}

	@Override
	public Movie update(Movie movie) {
		// TODO Auto-generated method stub
		return em.merge(movie);
	}

	@Override
	public void delete(Movie movie) {
		// TODO Auto-generated method stub
		em.remove(movie);
	}

	

	

	

}
