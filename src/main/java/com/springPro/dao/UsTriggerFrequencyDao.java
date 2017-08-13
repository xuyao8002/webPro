package com.springPro.dao;

import com.springPro.entity.UsTriggerFrequency;

public interface UsTriggerFrequencyDao {
    int deleteByPrimaryKey(String id);

    int insert(UsTriggerFrequency record);

    int insertSelective(UsTriggerFrequency record);

    UsTriggerFrequency selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UsTriggerFrequency record);

    int updateByPrimaryKey(UsTriggerFrequency record);
}