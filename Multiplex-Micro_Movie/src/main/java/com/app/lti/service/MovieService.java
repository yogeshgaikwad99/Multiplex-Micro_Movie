package com.app.lti.service;

import java.util.List;
import java.util.Optional;

import com.app.lti.document.MovieDocument;

public interface MovieService {

	public MovieDocument addMovie(MovieDocument movieDocument);

	public Optional<MovieDocument> getMovieDetail(String movieId);

	public List<MovieDocument> findAllMovies();

	public boolean deleteMovie(String movieId);

	public void deleteAll();

	public MovieDocument updateMovieDetail(String movieId, MovieDocument movieDocument);
	
	

}
