package org.xujin.docs.controller2;

import org.reactivestreams.Publisher;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class PersonController {

    //从前台接收json/xml类型数据
    @PostMapping("/person")
    Mono<String> create(@RequestBody Publisher<Person> personStream) {
        return Mono.just("Welcome to reactive world ~");
    }
    //得到一个集合
    @GetMapping("/person")
    Flux<Person> list() {
        Person p=new Person();
        p.setAge(12);
        p.setUserName("张三");
        return null;
    }
    //RestFul 风格传参
    @GetMapping("/person/{id}")
    Mono<Person> findById(@PathVariable String id) {
        return null;
    }
}

