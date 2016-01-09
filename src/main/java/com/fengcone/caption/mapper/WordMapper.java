package com.fengcone.caption.mapper;

import com.fengcone.caption.domain.Word;

public interface WordMapper {
    int deleteByPrimaryKey(String id);

    int insert(Word record);

    int insertSelective(Word record);

    Word selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Word record);

    int updateByPrimaryKey(Word record);
}