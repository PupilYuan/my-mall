package com.springcloud.controller;

import com.springcloud.service.UserService;
import entities.CommonResult;
import entities.UserBean;
import entities.UserLogin;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@Slf4j
@ResponseBody
@RequestMapping("/user")
public class UserController {

    @Resource
    UserService userService;

    @PostMapping ("/add")
    public int addUser(@RequestBody UserBean userBean){
        int result = userService.addUser(userBean);
        if(result > 0){
            log.info("******插入的数据为：" + userBean);
            log.info("******插入结果：" + result);
            return userBean.getUid();
        }else{
            return -1;
        }
    }

    @GetMapping("/getById")
    public UserBean getUserById(int uid){
        UserBean userBean = userService.selectById(uid);
        log.info("******查询结果：" + userBean);

        if(userBean != null){
            //查询成功
            return userBean;
        }else{
            return null;
        }
    }

    @PostMapping("/update")
    public int update(@RequestBody UserBean userBean){
        return userService.updateUser(userBean);
    }

    @GetMapping("/getAll")
    public List<UserBean> getUserAll(){
        List<UserBean> userBean = userService.selectAll();
        log.info("******查询结果：" + userBean);

        if(userBean != null){
            //查询成功
            return userBean;
        }else{
            log.info("没有查询结果");
            return null;
        }
    }

    @GetMapping("/deleteById")
    public int deleteById(int uid){
        int result = userService.deleteById(uid);
        if (result == 1){
            log.info("删除成功："+uid);
            return result;
        }
        return -1;
    }

    @PostMapping("/loginExam")
    public int loginExam(@RequestBody UserLogin userLogin){
        return userService.LoginExam(userLogin);
    }
}
