package io.esev.ninja.accountssingle.service;

import io.esev.ninja.accountssingle.domain.ValidateTransaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ErrorHandling {

    public static final Logger LOGGER = LoggerFactory.getLogger(ErrorHandling.class);

    public String invalidTransaction(ValidateTransaction validateTransaction){

        LOGGER.info("*****************[2X] Invalid Transaction:");
        LOGGER.info("Tx: {}", validateTransaction);

        return validateTransaction.toString();
    }
}
