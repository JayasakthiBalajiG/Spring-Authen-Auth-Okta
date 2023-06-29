package com.dhyan.netman.service;



import com.dhyan.netman.model.Movie;

import java.util.List;
import java.util.Optional;

public interface IMovieService {

	
	public List<Movie> findAllMovies() ;

	public Optional<Movie> findMovieById(int id);
	
	public Movie findByMovieName(String MovieName) ;

	public Movie findByComments(String Comments);

}
