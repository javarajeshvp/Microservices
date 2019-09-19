package com.microservices.moviecatalogservice.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.microservices.moviecatalogservice.model.CatalogItem;
import com.microservices.moviecatalogservice.model.Movie;
import com.microservices.moviecatalogservice.model.Rating;
import com.microservices.moviecatalogservice.model.UserRating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private WebClient.Builder webClientBuilder;

	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
		
		
		List<CatalogItem> catalogList = new ArrayList<CatalogItem>();
		List<Rating> ratings = null;
		/*
		ratings = new ArrayList<Rating>();
		ratings.add((new Rating("M1", 4)));
		ratings.add((new Rating("M2", 5)));
		*/
		UserRating userRating = restTemplate.getForObject("http://localhost:8082/ratingsdata/users/"+userId,UserRating.class );
		ratings = userRating.getRatings();  
		for (Rating rating : ratings) {

			Movie movie = restTemplate.getForObject("http://localhost:8081/movies/" + rating.getMovieId(), Movie.class);

			//Movie movie = webClientBuilder.build().get().uri("http://localhost:8081/movies/" + rating.getMovieId()).retrieve().bodyToMono(Movie.class).block();
			catalogList.add(new CatalogItem(movie.getMovieName(), "Desc", rating.getRating()));
			
		}
		return catalogList;
	}

	/*
	 * @RequestMapping("/{userId}") public List<CatalogItem>
	 * getCatalog(@PathVariable("userId") String userId){ List<CatalogItem>
	 * catalogList = new ArrayList<CatalogItem>(); catalogList.add(new
	 * CatalogItem("Transaformers","Test",4)); return catalogList; }
	 */

}
