/**
 * Copyright (C), 2020, 天气科技（北京）有限公司
 * FileName: DeptController_Consumer
 * Author:   qimeng
 * Date:     2020/6/5 14:11
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.qimeng.springcloud.controller;

import com.qimeng.springcloud.entities.Dept;
import com.qimeng.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author qimeng
 * @create 2020/6/5
 * @since 1.0.0
 */
@RestController
public class DeptController_Consumer {

    @Autowired
    private DeptClientService clientService;

    @RequestMapping(value = "/consumer/dept/add")
    public boolean add(Dept dept){
        return clientService.add(dept);
    }

    @RequestMapping(value = "/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return clientService.get(id);
    }

    @RequestMapping(value = "/consumer/dept/list")
    public List<Dept> list(){
        return clientService.list();
    }


}