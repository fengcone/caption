package com.fengcone.caption.param;

import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fengcone.caption.domain.Movie;

public class ChooseDTO extends Param{
	private static final long serialVersionUID = 32682416L;
	private List<Movie> movies;
	public List<Movie> getMovies() {
		return movies;
	}
	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}
}
