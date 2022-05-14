package com.springcloud.controller;


import com.springcloud.service.GoodService;
import entities.GoodBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/mall")
@Slf4j
public class HomeController {

    /**
     * 调用微服务模块的名称
     */
    //public static final String PAYMENT_URL = "http://mall-goods";
    /* @Resource
    private RestTemplate restTemplate;*/

    @Resource
    GoodService goodService;

    @RequestMapping("/home")
    public String goodsItem(@RequestParam(value = "uid",required = false)String uid, Model model)
    {
        if (uid!=null)
            model.addAttribute("uid",uid);
        List<GoodBean> result = goodService.goodItem();
        log.info("********商品列表返回：" + result);
        //将参数返回页面
        model.addAttribute("goodsItem",result);
        return "index";

        //采用restTemplate方法调用模块映射（controller）
        // GoodBean[] result = restTemplate.getForObject(PAYMENT_URL + "/goods/getAll",GoodBean[].class);
    }

}
