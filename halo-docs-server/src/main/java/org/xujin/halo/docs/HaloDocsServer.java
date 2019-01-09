package org.xujin.halo.docs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
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
@EnableWebMvc
public class HaloDocsServer {

    @Bean
    public WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerFactoryCustomizer(){
        return new WebServerFactoryCustomizer<ConfigurableWebServerFactory>() {
            @Override
            public void customize(ConfigurableWebServerFactory factory) {
                factory.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/index.html"));
                factory.addErrorPages(new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/index.html"));
            }
        };
    }
    @Bean
    public Filter corsFillter() {
        return new CorsFillter();
    }

    public static void main(String[] args) {
        SpringApplication.run(HaloDocsServer.class, args);
    }
}
