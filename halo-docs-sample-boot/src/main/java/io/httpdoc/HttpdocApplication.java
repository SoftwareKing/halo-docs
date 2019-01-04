package io.httpdoc;

import org.xujin.halo.docs.starter.EnableDoc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDoc(
        packages = {"io.httpdoc"},
        httpdoc = "服务名称",
        version = "服务版本",
        description = "服务描述-支持HTML语法。"
)
public class HttpdocApplication {
    public static void main(String[] args) {
        SpringApplication.run(HttpdocApplication.class, args);
    }
}