package com.bkjk.platform.halo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import javax.servlet.Filter;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class HaloDocsServer {

    @Bean
    public Filter corsFillter() {
        return new CorsFillter();
    }

    public static void main(String[] args) {
        SpringApplication.run(HaloDocsServer.class, args);
    }
}
