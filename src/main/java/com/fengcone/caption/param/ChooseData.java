package com.fengcone.caption.param;

import java.util.List;

import com.fengcone.caption.domain.Movie;

public class ChooseData extends Param{
	private static final long serialVersionUID = 32682416L;
	private List<Movie> movies;
	public List<Movie> getMovies() {
		return movies;
	}
	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}
	

}
