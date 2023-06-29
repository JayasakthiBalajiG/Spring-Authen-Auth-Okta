package com.dhyan.netman.model;


import jakarta.persistence.*;

@Entity
@Table(name="movie")
public class Movie {

	@Id
	@Column(name="movie_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int movieId;

	@Column(name="movie_name")
	private String movieName;

	@Column(name="price")
	private int price;

	@Column(name="director")
	private String director;

	@Column(name="genre")
	private String genre;

	@Column(name = "comments")
	private String comments;

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Movie(int movieId, String movieName, int price, String director, String genre, String comments) {
		this.movieId = movieId;
		this.movieName = movieName;
		this.price = price;
		this.director = director;
		this.genre = genre;
		this.comments= comments;
	}

	
	public Movie() {
		super();
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public Movie(String movieName) {
		this.movieName = movieName;
	}
}
