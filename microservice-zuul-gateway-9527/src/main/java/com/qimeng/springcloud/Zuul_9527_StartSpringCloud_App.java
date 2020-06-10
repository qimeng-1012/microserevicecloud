package com.qimeng.springcloud; /**
 * Copyright (C), 2020, 天气科技（北京）有限公司
 * FileName: DeptProvider8001_App
 * Author:   qimeng
 * Date:     2020/6/4 11:41
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.EnableZuulServer;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author qimeng
 * @create 2020/6/4
 * @since 1.0.0
 */
@EnableZuulProxy
@SpringBootApplication
@EnableZuulServer
public class Zuul_9527_StartSpringCloud_App
{
    public static void main(String[] args) {
        SpringApplication.run(Zuul_9527_StartSpringCloud_App.class,args);
    }
}