package com.example.bk.controller;

import com.alibaba.fastjson2.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Jamie Hong
 * @Description:
 * @create: 2024/12/25 10:47
 */
@RestController
public class Demo {

    @GetMapping("/index")
    @ResponseBody
    public JSONObject index()  {
        var response = new JSONObject();
        response.put("a", "b");
        return response;
    }

}
