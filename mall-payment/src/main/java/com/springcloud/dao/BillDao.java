package com.springcloud.dao;

import entities.BillBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BillDao {

    public int add(@Param("billBean") BillBean billBean);

    /*@Select({"select * from tb_mall_shopping_cart_item where uid = #{uid}"})*/
    public List<BillBean> getById(@Param("uid") int uid);
}
