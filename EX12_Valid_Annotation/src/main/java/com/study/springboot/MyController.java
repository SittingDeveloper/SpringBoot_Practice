package com.study.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller
public class MyController {

    @GetMapping("/")
    public @ResponseBody
    String root() throws Exception {
        return "Valid_Annotation";
    }

    @GetMapping("/insertForm")
    public String insert1() {
        return "createPage";
    }

    @RequestMapping("/create")
    public String insert2(@ModelAttribute("dto") @Valid ContentDto contentDto, BindingResult result) {
        String page = "createDonePage";
        System.out.println(contentDto);

        if (result.hasErrors()) {
            if (result.getFieldError("writer") != null) {
                System.out.println("1: " + result.getFieldError("writer").getDefaultMessage());
            }
            if (result.getFieldError("content") != null) {
                System.out.println("2: " + result.getFieldError("content").getDefaultMessage());
            }

            page = "createPage";
        }

        return page;
    }

}
