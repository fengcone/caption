package com.fengcone.caption.mapper;

import java.util.List;

import com.fengcone.caption.domain.Caption;

public interface CaptionMapper {
	int deleteByPrimaryKey(String id);

	int insert(Caption record);

	int insertSelective(Caption record);

	Caption selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(Caption record);

	int updateByPrimaryKey(Caption record);

	List<Caption> selectByCondition(Caption caption);
}