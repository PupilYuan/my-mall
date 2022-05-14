package com.springcloud.service;


import entities.UserBean;
import entities.UserLogin;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@FeignClient(value = "mall-user")
public interface UserService {

    @GetMapping("/user/getAll")
    public List<UserBean> getUserAll();

    @GetMapping("/user/deleteById")
    public int deleteById(@RequestParam("uid") int uid);

    @PostMapping("/user/loginExam")
    public int loginExam(@RequestBody UserLogin userLogin);

    @PostMapping("/user/add")
    public int add(@RequestBody UserBean userBean);

    @PostMapping("/user/update")
    public int update(@RequestBody UserBean userBean);

    @GetMapping("/user/getById")
    public UserBean getById(@RequestParam("uid")int uid);
}
