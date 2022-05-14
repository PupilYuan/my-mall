package com.springcloud.controller;

import com.springcloud.service.UserService;
import entities.UserBean;
import entities.UserLogin;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/mall/user")
public class UserController {

    @Resource
    UserService userService;

    @GetMapping("/login")
    public String login(){
        return "userlogin";
    }

    @RequestMapping(value = "/loginExam",method = RequestMethod.POST)
    public String loginExam(UserLogin userLogin, Model model){

        log.info("登录验证传递的参数为："+userLogin);
        int result = userService.loginExam(userLogin);

        //登录成功，返回用户id和商品列表到首页
        if (result == 1) {
            model.addAttribute("uid",userLogin.getUid());
            System.out.println("传递的uid为"+userLogin.getUid());
            return "forward:/mall/home";
        }
        //失败，携带提升信息返回登录页
        else {
            model.addAttribute("faultInfo","账号密码错误");
            return "userlogin";
        }
    }

    @GetMapping("/register")
    public String register(){
        return "userRegister";
    }

    @RequestMapping("/registerExam")
    public String registerTwo(UserBean userBean){

        int result = userService.add(userBean);
        if (result>0){
            log.info("注册成功,id为："+result);
            return "userlogin";
        }
        return null;
    }

    @RequestMapping("/update")
    //携带用户信息跳转到修改页
    public String update(@RequestParam int uid,Model model){
        UserBean userBean = userService.getById(uid);
        if (!userBean.equals(null)) {
            model.addAttribute("userInfo",userBean);
            return "userUpdate";
        }
        return "forward:/mall/user/login";
    }

    @PostMapping("/updateExam")
    public String updateExam(UserBean userBean,Model model){

        int result = userService.update(userBean);
        //登录成功，返回用户id和商品列表到首页

        model.addAttribute("uid",userBean.getUid());
        if (result >0) {
            return "forward:/mall/home";
        }
        //失败，携带提升信息返回登录页
        else {
            model.addAttribute("faultInfo","修改失败");
            return "forward:/mall/user/login";
        }
    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam int uid){
        userService.deleteById(uid);
        return "forward:/mall/home";
    }

    @GetMapping("/getAll")
    public String getUserAll(Model model){
        List<UserBean> userBeans = userService.getUserAll();
        System.out.println(userBeans);
        model.addAttribute("userItem",userBeans);
        return "userList";
    }

}
