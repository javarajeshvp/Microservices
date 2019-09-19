package com.microservices.movieinfoservice.resources;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.movieinfoservice.model.Movie;

@RestController
@RequestMapping("/movies")
public class MovieResources {
	@RequestMapping("/{MovieID}")
	public Movie getMovieInfor(@PathVariable("MovieID") String movieId) {
		return new Movie("M2","Titanic Movie");
		
	}

}
