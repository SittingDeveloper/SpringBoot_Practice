package com.study.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

    @GetMapping("/")
    public @ResponseBody
    String root() throws Exception {
        return "Lombok 사용하기";
    }

    @GetMapping("/test3")
    public String test3(Member member) {
        return "test3";
    }
}
