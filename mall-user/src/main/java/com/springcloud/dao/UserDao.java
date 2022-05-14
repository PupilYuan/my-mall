package com.springcloud.dao;

import entities.UserBean;
import entities.UserLogin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.lang.reflect.Array;
import java.util.ArrayList;

@Mapper
public interface UserDao {

    /**
     * 插入一个对象
     * @param userBean
     * @return
     */
    public int addUser(@Param("userBean") UserBean userBean);

    /**
     * 删除一个对象根据uid
     * @param uid
     */
    public int deleterById(int uid);

    /**
     * 修改用户信息
     * @param userBean
     */
    public int updateUser(@Param("userBean")UserBean userBean);

    /**
     * 查找全部用户信息
     * @return
     */
    public ArrayList<UserBean> selectAll();

    /**
     * 根据ID查找用户信息
     * @return
     */
    public UserBean selectById(int uid);

    public ArrayList<UserBean> loginExam(@Param("userLogin") UserLogin userLogin);
}
