package com.fengcone.caption.mapper;

import com.fengcone.caption.domain.Package;

public interface PackageMapper {
    int deleteByPrimaryKey(String id);

    int insert(Package record);

    int insertSelective(Package record);

    Package selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Package record);

    int updateByPrimaryKey(Package record);
}