/**
 * Copyright (C), 2020, 天气科技（北京）有限公司
 * FileName: DeptController
 * Author:   qimeng
 * Date:     2020/6/4 11:34
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.qimeng.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.qimeng.springcloud.entities.Dept;
import com.qimeng.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author qimeng
 * @create 2020/6/4
 * @since 1.0.0
 */
@RestController
public class DeptController {
    @Autowired
    private DeptService service;
    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/dept/discovery",method = RequestMethod.GET)
    public Object discovery(){
        List<String> list = discoveryClient.getServices();
        System.out.println("************");
        List<ServiceInstance> srvList = discoveryClient.getInstances("MICROSERVICECLOUD-DEPT");
        for (ServiceInstance element : srvList){
            System.out.println(element.getServiceId()+"\t"+element.getHost()+"\t"+element.getPort()
                    +"\t"+element.getUri());
        }
        return discoveryClient;
    }

    @RequestMapping(value = "/dept/add",method = RequestMethod.POST)
    public boolean add(@RequestBody Dept dept) {
        return service.add(dept);
    }
    @RequestMapping(value = "/dept/get/{id}",method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "processHystrix_Get")
    public Dept get(@PathVariable("id") Long id) {
        Dept dept = service.get(id);
        if (null == dept){
            throw new RuntimeException("该"+id +"没有相对应的信息");
        }
        return  dept;
    }

    public Dept processHystrix_Get(@PathVariable("id") Long id) {
        Dept d  = new Dept();
        d.setDeptno(id);
        d.setDname("该ID"+id +"没有相对应的信息,null--@HystrixCommand");
        d.setDb_source("没有对应数据库");
        return  d;
    }
    @RequestMapping(value = "/dept/list",method = RequestMethod.GET)
    public List<Dept> list() {
        return service.list();
    }
}