package com.fengcone.caption.domain.mapper;

import com.fengcone.caption.domain.Movie;

public interface MovieMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Movie record);

    int insertSelective(Movie record);

    Movie selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Movie record);

    int updateByPrimaryKey(Movie record);
}