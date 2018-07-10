package com.zb.dao;

import com.zb.domain.TCar;

public interface TCarMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TCar record);

    int insertSelective(TCar record);

    TCar selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TCar record);

    int updateByPrimaryKey(TCar record);
}