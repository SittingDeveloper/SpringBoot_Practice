package com.kms.ex03_annotationdi.bean;

import org.springframework.stereotype.Component;

@Component("printerA")
public class PrinterA implements Printer{

    @Override
    public void print(String message) {
        System.out.println("Printer A : " + message);
    }
}
