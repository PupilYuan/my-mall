package com.springcloud.service;

import entities.BillBean;
import entities.OrderBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
@FeignClient(value = "mall-order")
public interface OrderService {

    @PostMapping("/order/add")
    public int addOrder(@RequestBody OrderBean orderBean);

    @RequestMapping("/order/getById")
    public List<OrderBean> getById(@RequestParam("uid") int uid);

    /*@RequestMapping("/order/payment")*/
    @RequestMapping("/order/cancelOrder")
    public int cancelOrder(@RequestParam("uid")int uid,@RequestParam("gid")int gid);

    @RequestMapping ("/order/payment")
    public int payment(@SpringQueryMap BillBean billBean);

    @RequestMapping("/order/billByID")
    public List<BillBean> getBillById(@RequestParam("uid") int uid);
}
