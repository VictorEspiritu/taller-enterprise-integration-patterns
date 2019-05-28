package io.esev.ninja.accountssingle.service;

import io.esev.ninja.accountssingle.domain.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionService.class);

    public String execute(Transaction transaction){

        LOGGER.info("************* TransactionService.Execute **************");
        // TODO

        return transaction.toString();
    }
}
