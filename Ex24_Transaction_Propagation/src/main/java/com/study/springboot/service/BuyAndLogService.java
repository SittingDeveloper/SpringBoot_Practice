package com.study.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

@Service
public class BuyAndLogService {

    @Autowired
    BuyTicketService buyTicket;
    @Autowired
    LogWriteService logWrite;
    @Autowired
    TransactionTemplate transactionTemplate;

    public int buy(String consumerId, int amount, String error) {
        try {
            transactionTemplate.execute(new TransactionCallbackWithoutResult() {
                @Override
                protected void doInTransactionWithoutResult(TransactionStatus status) {
                    buyTicket.buy(consumerId, amount, error);

                    // 의도된 에러 발생시키기
                    if (error.equals("2")) {
                        int n = 10 / 0;
                    }
                    logWrite.write(consumerId, amount);

                }
            });

            return 1;
        } catch (Exception e) {
            System.out.println("[Transaction Propagation #1] Rollback");
            return 0;
        }
    }
}
