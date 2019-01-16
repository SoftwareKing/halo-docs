package org.xujin.docs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.xujin.halo.docs.starter.EnableDoc;

@SpringBootApplication
@EnableDoc(
        packages = {"org.xujin.docs.controller"},
        httpdoc = "账户系统服务",
        version = "服务版本 1.2.0",
        description = "提供账户系统服务在线调试接口"
)
@EnableDiscoveryClient
public class HaloDocsApplication {


    /**
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedHeaders("*")
                        .allowedMethods("*")
                        .allowedOrigins("*");
            }
        };
    }
   **/
    public static void main(String[] args) {
        SpringApplication.run(HaloDocsApplication.class, args);
    }
}