package com.fengcone.caption.domain.mapper;

import com.fengcone.caption.domain.Caption;


public interface CaptionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Caption record);

    int insertSelective(Caption record);

    Caption selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Caption record);

    int updateByPrimaryKey(Caption record);
}