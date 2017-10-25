package com.htsat.cart.dao.slave;

import com.htsat.cart.model.REcSpu;
import com.htsat.cart.model.REcSpuExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface REcSpuReadMapper {
    int countByExample(REcSpuExample example);

    int deleteByExample(REcSpuExample example);

    int deleteByPrimaryKey(Long nspuid);

    int insert(REcSpu record);

    int insertSelective(REcSpu record);

    List<REcSpu> selectByExample(REcSpuExample example);

    REcSpu selectByPrimaryKey(Long nspuid);

    int updateByExampleSelective(@Param("record") REcSpu record, @Param("example") REcSpuExample example);

    int updateByExample(@Param("record") REcSpu record, @Param("example") REcSpuExample example);

    int updateByPrimaryKeySelective(REcSpu record);

    int updateByPrimaryKey(REcSpu record);
}