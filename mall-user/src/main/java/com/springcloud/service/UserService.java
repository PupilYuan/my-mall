package com.springcloud.service;


import entities.UserBean;
import entities.UserLogin;

import java.util.ArrayList;

public interface UserService {

    public int addUser(UserBean userBean);

    public int updateUser(UserBean userBean);

    public ArrayList<UserBean> selectAll();

    public UserBean selectById(int uid);

    public int LoginExam(UserLogin userLogin);

    public int deleteById(int uid);

}
