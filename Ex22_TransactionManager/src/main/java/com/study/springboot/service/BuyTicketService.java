package com.study.springboot.service;

import com.study.springboot.dao.ITransaction1Dao;
import com.study.springboot.dao.ITransaction2Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;

@Service
public class BuyTicketService implements IBuyTicketService{

    @Autowired
    ITransaction1Dao transaction1;
    @Autowired
    ITransaction2Dao transaction2;

    @Autowired
    PlatformTransactionManager transactionManager; // 트랜잭션 매니저
    @Autowired
    TransactionDefinition definition; // 트랜잭션 매니저에서 사용할 설정값을 기본 제공 값으로 사용

    @Override
    public int buy(String consumerId, int amount, String error) {

        // 트랜잭션 설정, 이 이후 DB 처리에 대해서 트랜잭션을 처리할 수 있게 된다.
        TransactionStatus status = transactionManager.getTransaction(definition);

        try {

            transaction1.pay(consumerId, amount);

            // 의도된 Error 발생
            if (error.equals("1")) {
                int n = 10 / 0;
            }

            transaction2.pay(consumerId, amount);

            transactionManager.commit(status); // Error 없으면 Commit

            return 1;

        } catch (Exception e) {
            System.out.println("[PlatformTransactionManager] RollBack");
            transactionManager.rollback(status); // Error 있으면 Rollback
            return 0;
        }
    }

}
