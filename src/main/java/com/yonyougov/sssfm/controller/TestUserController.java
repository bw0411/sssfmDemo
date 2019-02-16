package com.yonyougov.sssfm.controller;

import com.crux.core.web.Autofilled;
import com.yonyougov.sssfm.domain.TestUser;
import com.yonyougov.sssfm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: zhangshc
 * @Date: 2019/1/14 16:56
 * @Version 1.0
 */
//@RestController
@Controller
@RequestMapping("api/testUser")
public class TestUserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/saveUserAndGroup")
    @ResponseBody
    public TestUser saveUserAndGroup(@RequestBody @Autofilled TestUser user){
        return userService.saveUserAndGroup(user);
    }

    /*@RequestMapping(value = "/hello")
    public String hello(){
        return "hello";
    }*/
}
