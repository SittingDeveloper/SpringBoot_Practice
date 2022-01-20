package com.study.springboot.service;

import com.study.springboot.dao.ITransaction1Dao;
import com.study.springboot.dao.ITransaction2Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

@Service
public class BuyTicketService {

    @Autowired
    ITransaction1Dao transaction1;
    @Autowired
    ITransaction2Dao transaction2;
    @Autowired
    TransactionTemplate transactionTemplate;

    @Transactional(propagation = Propagation.REQUIRED)
    public int buy(String consumerId, int amount, String error) {
        // 트랜잭션 설정, 이 이후 DB 처리에 대해서 트랜잭션을 처리할 수 있게 된다.
        // TransactionStatus status = transactionManager.getTransaction(definition);

        try {
            transactionTemplate.execute(new TransactionCallbackWithoutResult() {
                @Override
                protected void doInTransactionWithoutResult(TransactionStatus status) {
                    transaction1.pay(consumerId, amount);

                    // 의도된 Error 발생
                    if (error.equals("1")) {
                        int n = 10 / 0;
                    }

                    transaction2.pay(consumerId, amount);
                }
            });

            return 1;

        } catch (Exception e) {
            System.out.println("[Transaction Propagation] RollBack");
            return 0;
        }
    }

}
