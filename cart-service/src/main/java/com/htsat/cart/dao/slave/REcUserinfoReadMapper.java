package com.htsat.cart.dao.slave;

import com.htsat.cart.model.REcUserinfo;
import com.htsat.cart.model.REcUserinfoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface REcUserinfoReadMapper {
    int countByExample(REcUserinfoExample example);

    int deleteByExample(REcUserinfoExample example);

    int deleteByPrimaryKey(Long nuserid);

    int insert(REcUserinfo record);

    int insertSelective(REcUserinfo record);

    List<REcUserinfo> selectByExample(REcUserinfoExample example);

    REcUserinfo selectByPrimaryKey(Long nuserid);

    int updateByExampleSelective(@Param("record") REcUserinfo record, @Param("example") REcUserinfoExample example);

    int updateByExample(@Param("record") REcUserinfo record, @Param("example") REcUserinfoExample example);

    int updateByPrimaryKeySelective(REcUserinfo record);

    int updateByPrimaryKey(REcUserinfo record);
}