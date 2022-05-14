package com.springcloud.controller;

import cn.hutool.core.date.DateTime;
import com.springcloud.service.GoodService;
import com.springcloud.service.OrderService;
import entities.BillBean;
import entities.GoodBean;
import entities.OrderBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/mall/order")
public class OrderController {
    @Resource
    OrderService orderService;
    @Resource
    GoodService goodService;

    @RequestMapping("/add")
    //验证登录状态，然后进入登录/支付
    public String add(@RequestParam(value = "uid",required = false,defaultValue = "fault")String uid, @RequestParam("gid") int gid, Model model){
        log.info("购买页面uid为："+uid+" gid为"+gid);
        if(!uid.equals("fault")) {
            model.addAttribute("uid", uid);
            GoodBean goodBean = goodService.getById(gid);
            model.addAttribute("good", goodBean);
            log.info("加入购物车-登录验证成功！");
            return "goodsPayment";
        }
        return "userlogin";
    }

    @PostMapping("/addTwo")
    public String addTwo(OrderBean orderBean,Model model){
        log.info("订单信息为："+orderBean);
        int result = orderService.addOrder(orderBean);
        if(result>0){
            model.addAttribute("uid",orderBean.getUid());
            log.info("加入购物车："+orderBean);
            return "forward:/mall/home";
        }
        return "index";
    }

    @RequestMapping("/myOrder")
    public String myOrder(@RequestParam(value = "uid",required = false,defaultValue = "fault") String uid,Model model){
        if (!uid.equals("fault")){
            List<OrderBean> orderBeans = orderService.getById(Integer.parseInt(uid));
            model.addAttribute("orders",orderBeans);
            model.addAttribute("uid",uid);
            return "/userShoppingCar";
        }
        return "userlogin";
    }

    @RequestMapping("/payment")
    public String payment(BillBean billBean,Model model){
        billBean.setPrice( billBean.getPrice() * billBean.getNumber());
        log.info("账单信息："+billBean);
        orderService.payment(billBean);
        model.addAttribute("uid",billBean.getUid());
        return "forward:/mall/order/myOrder";
    }

    @RequestMapping("/cancel")
    public String cancel(@RequestParam("uid")int uid,@RequestParam("gid")int gid,Model model){
        int result = orderService.cancelOrder(uid,gid);
        if(result>0){
            log.info("取消订单成功！");
            model.addAttribute("uid",uid);
            return "forward:/mall/home";
        }
        return "index";
    }

    @RequestMapping("/billById")
    public String getBillById(@RequestParam(value = "uid",required = false,defaultValue = "fault") String uid,Model model){
        if (!uid.equals("fault")) {
            List<BillBean> billBeans = orderService.getBillById(Integer.parseInt(uid));
            model.addAttribute("uid", uid);
            model.addAttribute("bills", billBeans);
            return "userBill";
        }
        return "userlogin";
    }
}
