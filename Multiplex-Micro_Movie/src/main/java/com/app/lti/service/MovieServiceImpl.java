package com.app.lti.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.lti.document.MovieDocument;
import com.app.lti.repository.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService {
	
	@Autowired
	private MovieRepository movieRepository;
	
	//Movie addeded
	 @Override 
	  public MovieDocument addMovie(MovieDocument movieDocument) 
	  { 
		 movieDocument.getName();
		 movieDocument.getCategory();
		 movieDocument.getProducer();
		 movieDocument.getDirector();
		 movieDocument.getReleaseDate();
		 return movieRepository.save(movieDocument);
	 }
	 
	 //Get Movie Details Using moivieId
	 @Override
	 public Optional<MovieDocument> getMovieDetail(String movieId)
	 {
		
		return movieRepository.findById(movieId);
		 
	 }
	 
	//find All Movies
	@Override
	public List<MovieDocument> findAllMovies() {
	
			return movieRepository.findAll();
	}
	
	 //delete by movie using userId
	@Override
	public boolean deleteMovie(String movieId) {
		if (movieRepository.existsById(movieId)) {
			  movieRepository.deleteById(movieId); return true; 
			  } else { 
				  return false; 
				  }
	}
		 
		
	//delete All user Account
	 @Override
	public void deleteAll()
	{
			movieRepository.deleteAll();
	}
		
	//Update movie by using movieId 
	 @Override
	public MovieDocument updateMovieDetail(String movieId, MovieDocument movieDocument)
	{
		movieDocument.setMovieId(movieId);
		return movieRepository.save(movieDocument);
	}

	

}
