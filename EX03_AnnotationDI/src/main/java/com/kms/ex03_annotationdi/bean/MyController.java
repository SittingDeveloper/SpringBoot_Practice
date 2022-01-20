package com.kms.ex03_annotationdi.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
    @Autowired
    Member member1;

    @Autowired
    @Qualifier("printerB")
    Printer printer;

    @Autowired
    Member member2;

    @RequestMapping("/")
    public @ResponseBody String root() {

        // 1. Member Bean 가져오기
        member1.print();

        // 2. PrinterB Bean 가져오기
        member1.setPrinter(printer);
        member1.print();

        // 3. 싱글톤인지 확인
        if (member1 == member2) {
            System.out.println("동일할 개체입니다");
        } else {
            System.out.println("다른 개체입니다");
        }

        return "Annotation 사용하기";
    }
}
