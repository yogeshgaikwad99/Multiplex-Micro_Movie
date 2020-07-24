package com.app.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.lti.document.MovieDocument;
import com.app.lti.service.MovieService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/movie/api")
public class MovieController {
		
		@Autowired
		private MovieService service; 
		
		
		@PostMapping(path = "/addMovie", produces = "application/json")		
		public ResponseEntity<MovieDocument> addMovie(@RequestBody MovieDocument movieDocument) {
			MovieDocument movie = this.service.addMovie(movieDocument);
			ResponseEntity<MovieDocument> response = 
					new ResponseEntity<MovieDocument>(movie,HttpStatus.OK);
			return response;
		}
		
		@GetMapping(path="/findById/{movieId}", produces = "application/json")
		public ResponseEntity<MovieDocument> getMovieByUsingId(@PathVariable(value = "movieId") String movieId) {
			
			if (movieId != null) {
					
				new ResponseEntity<MovieDocument>(HttpStatus.FOUND);
				return ResponseEntity.of(service.getMovieDetail(movieId));
				
			}
			return new ResponseEntity<MovieDocument>(HttpStatus.NOT_FOUND);
		}
			
		@GetMapping("/findAllMovies")
		public ResponseEntity<List<MovieDocument>> findAllMovies(MovieDocument movieDocument) {
			new ResponseEntity<MovieDocument>(HttpStatus.FOUND);
			return ResponseEntity.ok(service.findAllMovies());
		}

		@DeleteMapping(path="/deleteById/{movieId}", produces = "application/json")
		public void deleteMoviesByUsingId(@PathVariable(value = "movieId") String movieId) {
			
			service.deleteMovieById(movieId);

		}

		@DeleteMapping("/deleteAll")
		public void deleteAll(MovieDocument movieDocument) {
			
			service.deleteAll();

		}
		
		@PutMapping(path="/updateMovieDetail/{movieId}", produces = "application/json")
		public MovieDocument updateMovie(@PathVariable("movieId") String movieId, @RequestBody MovieDocument movieDocument)
		{
			return service.updateMovieDetail(movieId, movieDocument);
		}
		
}
