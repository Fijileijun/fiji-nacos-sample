package com.fiji.nacos.sample.simple.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/***
 * Nacos Service Consumer Application Sample
 *
 * @author  Jacobs Lei
 */
@EnableDiscoveryClient
@SpringBootApplication
public class NacosSampleSimpleConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosSampleSimpleConsumerApplication.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }



    @Slf4j
    @RestController
    static class TestController {

        @Autowired
        RestTemplate restTemplate;

        @GetMapping("/test")
        public String test() {
            // 通过spring cloud common中的负载均衡接口选取服务提供节点实现接口调用
            String responseString = restTemplate.getForObject("http://nacos-sample-provider-application/hello?name=jaocbs", String.class);
            return responseString;
        }
    }
}
