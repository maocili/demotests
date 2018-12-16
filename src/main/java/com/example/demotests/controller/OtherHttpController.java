package com.example.demotests.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


//测试http的post、del put请求
@RestController
public class OtherHttpController {

    private Map<String, Object> params = new HashMap<>();

    @PostMapping("/v1/login")
    public Object login(String id, String pwd) {

        params.clear();
        params.put("id", id);
        params.put("pwd", pwd);
        return params;
    }




}
