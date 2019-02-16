package com.yonyougov.sssfm.controller;

import com.alibaba.fastjson.JSONArray;
import com.crux.core.web.Autofilled;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yonyougov.sssfm.domain.SssfmIoBillTest;
import com.yonyougov.sssfm.service.SssfmIoBillTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: zhangshc
 * @Date: 2019/1/9 11:23
 * @Version 1.0
 */
@RestController
//@Controller
@RequestMapping(name = "api/sssfmIoBillTest")
public class SssfmIoBillTestController {

    @Autowired
    private SssfmIoBillTestService sssfmIoBillTestService;


    @PostMapping
    public SssfmIoBillTest save(@RequestBody @Autofilled SssfmIoBillTest bill){
        bill = sssfmIoBillTestService.save(bill);
//        model.addAttribute("bill",bill);
        return bill;
    }

    @RequestMapping("/list")
    public String list(Model model){
        List<SssfmIoBillTest> billList = sssfmIoBillTestService.queryList();
        model.addAttribute("billList",billList);
        return "sssfmIoBill_list";

    }


    @RequestMapping("/listJsonp")
    public String list(@RequestParam(name = "callBack")String callBack) throws Exception{
        List<SssfmIoBillTest> billList = sssfmIoBillTestService.queryList();
//        ObjectMapper objectMapper = new ObjectMapper();
//        String results = objectMapper.writeValueAsString(billList);
        String results = JSONArray.toJSONString(billList);
        return callBack+"("+results+")";

    }

}
