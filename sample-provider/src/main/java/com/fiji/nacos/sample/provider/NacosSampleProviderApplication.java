package com.fiji.nacos.sample.provider;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/***
 * Nacos Sample simple provider Application
 *
 * @author  Jacobs Lei
 */
@SpringBootApplication
@EnableDiscoveryClient
@Slf4j
public class NacosSampleProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosSampleProviderApplication.class, args);
    }

    @Slf4j
    @RestController
    static class TestController {
        @GetMapping("/hello")
        public String hello(@RequestParam String name) {
            log.info("invoked name = " + name);
            return "hello " + name;
        }
    }
}
