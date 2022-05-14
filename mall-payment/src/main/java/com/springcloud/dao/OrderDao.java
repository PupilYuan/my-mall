package com.springcloud.dao;

import entities.OrderBean;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OrderDao {

    /**
     * 生成订单
     */
    public int add(@Param("orderBean")OrderBean orderBean);

    @Select("select * from tb_mall_order where uid = #{uid}")
    public List<OrderBean> getById(@Param("uid")int uid);

    @Delete("delete from tb_mall_order where uid=#{uid} and gid=#{gid}")
    public int CancelOrder(@Param("uid")int uid,@Param("gid")int gid);
}
