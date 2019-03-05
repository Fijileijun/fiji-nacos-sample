package com.fiji.nacos.sample.config.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 * @author  Jacobs Lei
 */
@SpringBootApplication
public class NacosSampleConfigClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosSampleConfigClientApplication.class, args);
    }

    @Slf4j
    @RestController
    @RefreshScope
    static class TestController {

        @Value("${name:}")
        private String name;

        @GetMapping("/hello")
        public String hello() {
            return "hello " + name;
        }

    }
}
