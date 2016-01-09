package com.fengcone.caption.domain;

public class Movie {
	private Long id;

	private Long movieId;

	private String movieName;

	private Integer movieTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMovieId() {
		return movieId;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName == null ? null : movieName.trim();
	}

	public Integer getMovieTime() {
		return movieTime;
	}

	public void setMovieTime(Integer movieTime) {
		this.movieTime = movieTime;
	}

	@Override
	public String toString() {
		return "Movie [" + (id != null ? "id=" + id + ", " : "")
				+ (movieId != null ? "movieId=" + movieId + ", " : "")
				+ (movieName != null ? "movieName=" + movieName + ", " : "")
				+ (movieTime != null ? "movieTime=" + movieTime : "") + "]";
	}
}