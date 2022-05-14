package com.springcloud.Impl;

import com.springcloud.service.GoodService;
import entities.GoodBean;
import org.springframework.stereotype.Service;

import java.util.List;

//在引入Openfeign后没使用
@Service
public class HomePapaServiceImpl implements GoodService {

    public List<GoodBean> goodItem() {
        return null;
    }

    public GoodBean getById(int gid) {
        return null;
    }
}
