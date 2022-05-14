package com.springcloud.Impl;

import com.springcloud.dao.BillDao;
import com.springcloud.service.BillService;
import entities.BillBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class BillServiceImpl implements BillService {

    @Resource
    BillDao billDao;

    public int add(BillBean billBean) {
        log.info("传递的账单数据为："+billBean);
        return billDao.add(billBean);
    }

    public List<BillBean> getById(int uid){
        return billDao.getById(uid);
    }
}
