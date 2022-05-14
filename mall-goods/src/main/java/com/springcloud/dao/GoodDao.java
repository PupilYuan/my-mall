package com.springcloud.dao;

import entities.GoodBean;
import entities.UserBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

@Mapper
public interface GoodDao {

    /**
     * 添加一个商品
     * @param goodBean
     * @return
     */
    public int addGood(GoodBean goodBean);

    /**
     * 删除一个对象根据uid
     * @param gid
     */
    public int deleterById(int gid);

    /**
     * 修改商品信息
     * @param goodBean
     */
    public int updateUser(GoodBean goodBean);

    /**
     * 查找全部商品信息
     * @return
     */
    public ArrayList<GoodBean> selectAll();

    /**
     * 根据id查找商品信息
     * @param gid
     * @return
     */
    public GoodBean selectById(@Param("gid") int gid);
}
