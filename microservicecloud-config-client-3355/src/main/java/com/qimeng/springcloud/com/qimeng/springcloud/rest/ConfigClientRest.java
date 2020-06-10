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
package com.qimeng.springcloud.com.qimeng.springcloud.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author qimeng
 * @create 2020/6/4
 * @since 1.0.0
 */
public class ConfigClientRest
{
    @Value("${spring.application.name}")
    private String applicationName;
    @Value("${eureka.client.service-url.defaultZone}")
    private String eurekaServers;
    @Value("${server.port}")
    private String port;

    @RequestMapping(value = "/config")
    public String getConfig(){
        String str = "applicationName:"+applicationName+"\t"+"eurekaServers:"+eurekaServers
                +"\t"+"port:"+port;
        System.out.println(str);

        return str;

    }
}