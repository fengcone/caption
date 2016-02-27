package com.fengcone.caption.mapper;

import java.util.List;

import com.fengcone.caption.domain.Movie;

public interface MovieMapper {
    int deleteByPrimaryKey(String id);

    int insert(Movie record);

    int insertSelective(Movie record);

    Movie selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Movie record);

    int updateByPrimaryKey(Movie record);
    
    List<Movie> selectAll();
}