/**
 * Copyright (C), 2020, 天气科技（北京）有限公司
 * FileName: DeptServiceImpl
 * Author:   qimeng
 * Date:     2020/6/4 11:31
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.qimeng.springcloud.service.impl;

import com.qimeng.springcloud.dao.DeptDao;
import com.qimeng.springcloud.entities.Dept;
import com.qimeng.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author qimeng
 * @create 2020/6/4
 * @since 1.0.0
 */
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptDao dao;

    @Override
    public boolean add(Dept dept) {
        return dao.addDept(dept);
    }

    @Override
    public Dept get(Long id) {
        Dept dept = dao.findById(id);
        dept.setDb_source("test03");
        return dept;
    }

    @Override
    public List<Dept> list() {
        return dao.findAll();
    }
}