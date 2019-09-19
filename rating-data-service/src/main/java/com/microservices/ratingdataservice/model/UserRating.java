package com.microservices.ratingdataservice.model;

import java.util.List;

public class UserRating {

	private List<Rating> ratings;
	private String author;
	public String getAuthor() {
	return author;
}

public void setAuthor(String author) {
	this.author = author;
}

	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

}
