package com.yonyougov.sssfm.controller;

import com.crux.core.web.Autofilled;
import com.yonyougov.sssfm.domain.TestGroup;
import com.yonyougov.sssfm.domain.TestUser;
import com.yonyougov.sssfm.service.GroupService;
import com.yonyougov.sssfm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Author: zhangshc
 * @Date: 2019/1/14 13:11
 * @Version 1.0
 */
@RestController
@RequestMapping("api/testGroup")
public class TestGroupController {

    @Autowired
    private GroupService groupService;

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public TestGroup save(@RequestBody @Autofilled TestGroup group){
        return groupService.save(group);
    }
}
