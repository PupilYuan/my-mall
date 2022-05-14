package com.springcloud.controller;

import cn.hutool.core.date.DateTime;
import com.springcloud.service.BillService;
import com.springcloud.service.OrderService;
import entities.BillBean;
import entities.OrderBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    @Resource
    OrderService orderService;
    @Resource
    BillService billService;

    @PostMapping("/add")
    public int addOrder(@RequestBody OrderBean orderBean){
        return orderService.add(orderBean);
    }

    @RequestMapping("/getById")
    public List<OrderBean> getById(@RequestParam("uid") int uid){
        return orderService.getById(uid);
    }

    @RequestMapping("/cancelOrder")
    public int cancelOrder(@RequestParam("uid")int uid,@RequestParam("gid")int gid) {
        return orderService.cancelOrder(uid, gid);
    }

    @RequestMapping("/payment")
    public int payment(BillBean billBean){
        billBean.setTime(DateTime.now());
        log.info("数据为："+billBean);
        billService.add(billBean);
        orderService.cancelOrder(billBean.getUid(),billBean.getGid());
        return 1;
    }

    @RequestMapping("/billByID")
    public List<BillBean> getBillById(@RequestParam("uid") int uid){
        return billService.getById(uid);
    }
}
