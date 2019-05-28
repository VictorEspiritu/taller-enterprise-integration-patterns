package io.esev.ninja.accountssingle.service;

import io.esev.ninja.accountssingle.domain.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class Transaction {

    private static final Logger LOGGER = LoggerFactory.getLogger(Transaction.class);

    public String execute(Account account){

        LOGGER.info("************* Transaction.Execute **************");
        // TODO

        return account.toString();
    }
}
