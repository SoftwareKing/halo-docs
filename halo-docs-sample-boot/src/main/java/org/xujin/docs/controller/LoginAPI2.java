package org.xujin.docs.controller;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.xujin.docs.model.Gender;
import org.xujin.docs.model.LoginResult;
import org.xujin.docs.model.User;

import java.util.Date;
import java.util.Random;


@RestController
@RequestMapping("/login2")
public class LoginAPI2 {

    @RequestMapping(method = RequestMethod.GET)
    public LoginResult login(String username, String password) {
        LoginResult result = new LoginResult();

        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            result.setCode(400);
            result.setMessage("用户名或密码错误");
            return result;
        }

        User user = new User();
        user.setId(Math.abs(new Random().nextLong()));
        user.setUsername(username);
        user.setPassword(password);
        user.setBirthday(new Date());
        user.setAge(18);
        user.setGender(Gender.MALE);

        result.setUser(user);

        return result;
    }

    @PostMapping("/add")
    public LoginResult addUser(@RequestBody User user) {
        LoginResult loginResult=new LoginResult();
        user.setId(Math.abs(new Random().nextLong()));
        user.setUsername("张三");
        user.setPassword("张三");
        user.setBirthday(new Date());
        user.setAge(18);
        user.setGender(Gender.MALE);

        loginResult.setUser(user);

        return loginResult;
    }


}
