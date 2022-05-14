package com.springcloud.service;

import entities.BillBean;
import org.springframework.context.annotation.Bean;

import java.util.List;

public interface BillService {

    public int add(BillBean billBean);

    public List<BillBean> getById(int uid);
}
