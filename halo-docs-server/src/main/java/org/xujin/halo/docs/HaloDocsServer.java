package org.xujin.halo.docs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.xujin.halo.docs.starter.EnableDoc;

import javax.servlet.Filter;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
@EnableDoc(
        packages = {"org.xujin.halo.docs"},
        httpdoc = "账户系统服务",
        version = "服务版本 1.2.0",
        description = "提供账户系统服务在线调试接口"
)
public class HaloDocsServer {

    @Bean
    public Filter corsFillter() {
        return new CorsFillter();
    }

    public static void main(String[] args) {
        SpringApplication.run(HaloDocsServer.class, args);
    }
}
