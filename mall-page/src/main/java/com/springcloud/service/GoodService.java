package com.springcloud.service;

import entities.GoodBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
@FeignClient(value = "mall-goods")
public interface GoodService {

    @RequestMapping("/goods/getAll")
    public List<GoodBean> goodItem();

    @RequestMapping("/goods/getById")
    public GoodBean getById(@RequestParam("gid") int gid);
}
