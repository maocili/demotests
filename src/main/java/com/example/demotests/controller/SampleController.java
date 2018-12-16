package com.example.demotests.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Controller
//ResponseBody = @Controller + @ResponseBody

public class SampleController {


    //    @ResponseBody
//    在@ResponseBody 下会返回“index”字符串
    @RequestMapping("/index")
    public String home() {
        return "index";

    }

    @RequestMapping("/test")
    @ResponseBody
    public Map<String, String> testMap() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "123");
//        map.put("code","123");
        return map;
    }
}
