package com.springcloud.impl;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.springcloud.dao.GoodDao;
import com.springcloud.service.GoodService;
import entities.GoodBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

@Service
@DefaultProperties(defaultFallback = "mall_Global_FallbackMethod")
public class GoodServiceImpl implements GoodService {

    @Resource
    GoodDao goodDao;


    public int addGood(GoodBean goodBean) {
        return goodDao.addGood(goodBean);
    }

    public int deleterById(int gid) {
        return goodDao.deleterById(gid);
    }

    public int updateUser(GoodBean goodBean) {
        return goodDao.updateUser(goodBean);
    }


    @HystrixCommand(commandProperties = {
            //设置自身超时调用时间的峰值为3秒，峰值内可以正常运行，超过了需要有兜底的方法处理，服务降级fallback
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public ArrayList<GoodBean> selectAll() {
        return goodDao.selectAll();
    }

    /**
     * 服务熔断
     * @return
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),                      //开启断路器（以下是断路器相关配置）
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),         //请求总数阈值（默认20）
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),   //休眠时间窗口期（休眠多久进入半开模式（单位毫秒，默认5秒））
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),       //请求次数的错误率达到多少跳闸（百分率%，默认50%）
    })*/
    public GoodBean selectById(int gid) {
        return goodDao.selectById(gid);
    }

    public ArrayList<GoodBean> mall_Global_FallbackMethod(){
        System.out.println("服务运行失败：mall-goods");
        return null;
    }
}
