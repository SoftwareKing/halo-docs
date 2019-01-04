package org.xujin.docs;

import org.xujin.halo.docs.starter.EnableDoc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDoc(
        packages = {"org.xujin.docs.controller"},
        httpdoc = "服务名称",
        version = "服务版本",
        description = "服务描述-支持HTML语法。"
)
public class HalodocApplication {
    public static void main(String[] args) {
        SpringApplication.run(HalodocApplication.class, args);
    }
}