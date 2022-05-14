package com.springcloud.controller;

import com.springcloud.service.GoodService;
import entities.CommonResult;
import entities.GoodBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/goods")
public class GoodController {

    @Resource
    GoodService goodService;

    @RequestMapping("add")
    public CommonResult addGood(GoodBean goodBean){
        int result = goodService.addGood(goodBean);

        log.info("******插入的数据为：" + goodBean);
        log.info("******插入结果：" + result);

        if(result > 0){
            //插入成功
            return new CommonResult(200, "插入数据库成功", result);
        }else{
            return new CommonResult(444, "插入数据库失败");
        }
    }

    @RequestMapping("delete/{gid}")
    public CommonResult deleteGood(@PathVariable int gid){
        int result = goodService.deleterById(gid);

        log.info("******删除结果：" + result);

        if(result > 0){
            //插入成功
            return new CommonResult(200, "删除数据成功", result);
        }else{
            return new CommonResult(444, "删除数据失败");
        }
    }

    @RequestMapping("/update")
    public CommonResult updateGood(GoodBean goodBean){
        int result = goodService.updateUser(goodBean);

        log.info("******修改结果：" + result);

        if(result > 0){
            //插入成功
            return new CommonResult(200, "修改数据成功", result);
        }else{
            return new CommonResult(444, "删除数据失败");
        }
    }

    @RequestMapping("/getAll")
    public List<GoodBean> getAll(){
        ArrayList<GoodBean> result = goodService.selectAll();

        if (result != null) {
            CommonResult a = new CommonResult(200, "查询数据成功", result);
            System.out.println(a);
            return result;
        }
        else {
            CommonResult a = new CommonResult(444, "查询数据失败");
            System.out.println(a);
            return null;
        }
    }

    @RequestMapping("/getById")
    public GoodBean getById(@RequestParam int gid){
        GoodBean result = goodService.selectById(gid);

        if (result!=null) {
            log.info("查询成功！"+result);
            return result;
        }
        else {
           log.info("查询失败！");
            return null;
        }
    }

}
