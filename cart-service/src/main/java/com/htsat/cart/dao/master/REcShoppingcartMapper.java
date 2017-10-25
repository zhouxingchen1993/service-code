package com.htsat.cart.dao.master;

import com.htsat.cart.model.REcShoppingcart;
import com.htsat.cart.model.REcShoppingcartExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface REcShoppingcartMapper {
    int countByExample(REcShoppingcartExample example);

    int deleteByExample(REcShoppingcartExample example);

    int deleteByPrimaryKey(Long nshoppingcartid);

    int insert(REcShoppingcart record);

    int insertSelective(REcShoppingcart record);

    List<REcShoppingcart> selectByExample(REcShoppingcartExample example);

    REcShoppingcart selectByPrimaryKey(Long nshoppingcartid);

    int updateByExampleSelective(@Param("record") REcShoppingcart record, @Param("example") REcShoppingcartExample example);

    int updateByExample(@Param("record") REcShoppingcart record, @Param("example") REcShoppingcartExample example);

    int updateByPrimaryKeySelective(REcShoppingcart record);

    int updateByPrimaryKey(REcShoppingcart record);

    List<REcShoppingcart> selectByUserId(Long userId);
}