package com.springcloud.Impl;

import com.springcloud.dao.OrderDao;
import com.springcloud.service.OrderService;
import entities.OrderBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    OrderDao orderDao;

    public int add(OrderBean orderBean) {
        return orderDao.add(orderBean);
    }

    public List<OrderBean> getById(int uid){
        return orderDao.getById(uid);
    }

    public int cancelOrder(int uid, int gid) {
        return orderDao.CancelOrder(uid, gid);
    }
}
