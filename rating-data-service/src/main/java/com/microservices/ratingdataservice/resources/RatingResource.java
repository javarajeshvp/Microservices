package com.microservices.ratingdataservice.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.ratingdataservice.model.Rating;
import com.microservices.ratingdataservice.model.UserRating;

@RestController
@RequestMapping("/ratingsdata")
public class RatingResource {
	@RequestMapping("/{movieId}")
	public Rating getRating(@PathVariable("movieId") String movieId) {
		return new Rating("M2", 5);
	}

	@RequestMapping("users/{userId}")
	public UserRating getUserRating(@PathVariable("userId") String userId) {
		List<Rating> ratings = new ArrayList<Rating>();
		ratings.add(new Rating("Movie 1", 1));
		ratings.add(new Rating("Movie 2", 2));
		ratings.add(new Rating("Movie 3", 3));
		ratings.add(new Rating("Movie 4", 4));
		ratings.add(new Rating("Movie 5", 5));
		
		UserRating userRating = new UserRating();
		userRating.setRatings(ratings);
		userRating.setAuthor("Rajesh VP");
		return userRating;
	}
}
