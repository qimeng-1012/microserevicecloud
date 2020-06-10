/**
 * Copyright (C), 2020, 天气科技（北京）有限公司
 * FileName: ConfigBean
 * Author:   qimeng
 * Date:     2020/6/5 14:07
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.qimeng.springcloud.cfgbeans;


import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author qimeng
 * @create 2020/6/5
 * @since 1.0.0
 */
@Configuration
public class ConfigBean {
    @Bean
    @LoadBalanced//客户端 负载均衡
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Bean
    public IRule myRule() {
        return new RandomRule();
    }

}