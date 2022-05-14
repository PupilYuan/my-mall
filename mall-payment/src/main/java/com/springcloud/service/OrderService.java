package com.springcloud.service;

import entities.OrderBean;

import java.util.List;

public interface OrderService {

    public int add(OrderBean orderBean);

    public List<OrderBean> getById(int uid);

    public int cancelOrder(int uid,int gid);
}
