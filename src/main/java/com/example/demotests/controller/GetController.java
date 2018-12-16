package com.example.demotests.controller;

import com.example.demotests.vo.User;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
public class GetController {
    //restful协议

    private Map<String, Object> params = new HashMap<>();

    //    @RequestMapping(path = "/{city}/{user}", method = RequestMethod.GET)
//    public Object findUser(@PathVariable("city") String cityId,
//                           @PathVariable("user") String userId) {
//        params.clear();
//        params.put("city", cityId);
//        params.put("user", userId);
//
//        return params;
//    }
    @GetMapping(value = "/v1/page_user1")
    public Object pageUser(int from, int size) {
        //http://127.0.0.1:8080//v1/page_user1/?from=0&size=10
        params.clear();
        params.put("from", from);
        params.put("size", size);
        System.out.println("热加载1");
        System.out.println("热加载");
        return params;
    }

    @GetMapping(value = "/v2/page_user2")
    public Object pageUser2(@RequestParam(defaultValue = "0", name = "page") int from, int size) {
//        http://127.0.0.1:8080//v2/page_user2?size=100&page=100
//        http://127.0.0.1:8080//v2/page_user2?size=100
        params.clear();
        params.put("form", from);
        params.put("size", size);

        return params;

    }

    /*
     * bean对象传参
     *
     * http头为 application/json
     *
     * */
    @RequestMapping("/v1/save_user")
    public Object save_user(@RequestBody User user) {

        params.clear();
        params.put("user", user);
        return params;
    }

    @GetMapping("/v1/get_header")
    public Object getHeader(@RequestHeader("access_token") String accessToken, String id) {
        params.clear();
        params.put("token", accessToken);
        params.put("id", id);

        return params;
    }

    @GetMapping("/v1/test_request")
    public Object testRequest(HttpServletRequest request) {

        params.clear();
        String id = request.getParameter("id");
        params.put("id", id);
        return params;

    }

}
