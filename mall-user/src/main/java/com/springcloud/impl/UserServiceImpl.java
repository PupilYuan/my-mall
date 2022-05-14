package com.springcloud.impl;

import com.springcloud.dao.UserDao;
import com.springcloud.service.UserService;
import entities.UserBean;
import entities.UserLogin;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserDao userDao;

    public int addUser(UserBean userBean) {
        return userDao.addUser(userBean);
    }

    public int updateUser(UserBean userBean) {
        return userDao.updateUser(userBean);
    }

    public ArrayList<UserBean> selectAll() {
        return userDao.selectAll();
    }

    public UserBean selectById(int uid) {
        return userDao.selectById(uid);
    }

    public int deleteById(int uid) {
        int result = userDao.deleterById(uid);
        return result;
    }

    /**
     * 登录验证
     */
    public int LoginExam(UserLogin userLogin){
        ArrayList<UserBean>  userBeans = userDao.loginExam(userLogin);
        if(!userBeans.isEmpty()){
            System.out.println(userBeans);
            System.out.println("登录成功！");
            return 1;
        }
        System.out.println("登录失败！");
        return -1;
    }
}
