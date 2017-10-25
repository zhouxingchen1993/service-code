package com.htsat.cart.dao.master;

import com.htsat.cart.model.REcImage;
import com.htsat.cart.model.REcImageExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface REcImageMapper {
    int countByExample(REcImageExample example);

    int deleteByExample(REcImageExample example);

    int deleteByPrimaryKey(Long nimageid);

    int insert(REcImage record);

    int insertSelective(REcImage record);

    List<REcImage> selectByExample(REcImageExample example);

    REcImage selectByPrimaryKey(Long nimageid);

    int updateByExampleSelective(@Param("record") REcImage record, @Param("example") REcImageExample example);

    int updateByExample(@Param("record") REcImage record, @Param("example") REcImageExample example);

    int updateByPrimaryKeySelective(REcImage record);

    int updateByPrimaryKey(REcImage record);
}