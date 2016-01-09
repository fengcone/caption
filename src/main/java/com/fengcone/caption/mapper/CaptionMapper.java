package com.fengcone.caption.mapper;

import com.fengcone.caption.domain.Caption;

public interface CaptionMapper {
	int deleteByPrimaryKey(Long id);

	int insert(Caption record);

	int insertSelective(Caption record);

	Caption selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(Caption record);

	int updateByPrimaryKey(Caption record);
}