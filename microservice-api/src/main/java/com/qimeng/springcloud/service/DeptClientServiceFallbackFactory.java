/**
 * Copyright (C), 2020, 天气科技（北京）有限公司
 * FileName: DeptClientServiceFallbackFactory
 * Author:   qimeng
 * Date:     2020/6/9 11:00
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.qimeng.springcloud.service;

import com.qimeng.springcloud.entities.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author qimeng
 * @create 2020/6/9
 * @since 1.0.0
 */
@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {


    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public boolean add(Dept dept) {
                return false;
            }

            @Override
            public Dept get(Long id) {
                Dept d  = new Dept();
                d.setDeptno(id);
                d.setDname("该ID"+id +"没有相对应的信息,Consumer客户端提供的降级服务，此刻服务Provider已关闭");
                d.setDb_source("没有对应数据库");
                return d;
            }

            @Override
            public List<Dept> list() {
                return null;
            }
        };
    }
}