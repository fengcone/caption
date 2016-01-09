package com.fengcone.caption.mapper;

import java.util.List;

import com.fengcone.caption.domain.Movie;

public interface MovieMapper {
	int deleteByPrimaryKey(Long id);

	int insert(Movie record);

	int insertSelective(Movie record);

	Movie selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(Movie record);

	int updateByPrimaryKey(Movie record);

	List<Movie> selectAll();
	
	List<Movie> selectConditon(Movie movie);
}