package org.xujin.docs;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.xujin.halo.docs.starter.EnableDoc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDoc(
        packages = {"org.xujin.docs.controller"},
        httpdoc = "账户系统服务",
        version = "服务版本 1.2.0",
        description = "提供账户系统服务在线调试接口"
)
@EnableDiscoveryClient
public class HaloDocsApplication {
    public static void main(String[] args) {
        SpringApplication.run(HaloDocsApplication.class, args);
    }
}