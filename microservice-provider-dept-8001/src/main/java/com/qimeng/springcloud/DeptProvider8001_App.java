/**
 * Copyright (C), 2020, 天气科技（北京）有限公司
 * FileName: DeptProvider8001_App
 * Author:   qimeng
 * Date:     2020/6/4 11:41
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.qimeng.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author qimeng
 * @create 2020/6/4
 * @since 1.0.0
 */
@EnableEurekaClient
@SpringBootApplication
@EnableDiscoveryClient //服务发现
public class DeptProvider8001_App
{
    public static void main(String[] args) {
        SpringApplication.run(DeptProvider8001_App.class,args);
    }
}