package com.fengcone.caption.mapper;

import java.util.List;

import com.fengcone.caption.domain.Package;

public interface PackageMapper {
    int deleteByPrimaryKey(String id);

    int insert(Package record);

    int insertSelective(Package record);

    Package selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Package record);

    int updateByPrimaryKey(Package record);
    
    List<Package> selectByCondition(Package package1);
}