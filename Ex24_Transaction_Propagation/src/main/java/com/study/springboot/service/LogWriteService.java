package com.study.springboot.service;

import com.study.springboot.dao.ITransaction3Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogWriteService {

    @Autowired
    ITransaction3Dao transaction3;

    public int write(String consumerId, int amount) {
        try {
            transaction3.pay(consumerId, amount);
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }
}
