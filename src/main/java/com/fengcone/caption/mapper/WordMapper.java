package com.fengcone.caption.mapper;

import com.fengcone.caption.domain.Word;

public interface WordMapper {
	int deleteByPrimaryKey(Long id);

	int insert(Word record);

	int insertSelective(Word record);

	Word selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(Word record);

	int updateByPrimaryKey(Word record);
}