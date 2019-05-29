package io.esev.ninja.accountssingle.service;

import io.esev.ninja.accountssingle.domain.AccountTransfer;
import io.esev.ninja.accountssingle.domain.ValidateTransfer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ErrorHandling {

    public static final Logger LOGGER = LoggerFactory.getLogger(ErrorHandling.class);

    public String invalidTransaction(ValidateTransfer validateTransfer){

        LOGGER.info("*****************[2X] Invalid Transfer:");

        AccountTransfer transfer = validateTransfer.getTransfer();
        LOGGER.info("AccountSource:{}", transfer.getAccountSource());
        LOGGER.info("AccountTarget:{}", transfer.getAccountTarget());
        LOGGER.info("Amount:{}", transfer.getAmount());
        LOGGER.info("isAccount Valid:{}", validateTransfer.getValidateAccount());
        LOGGER.info("isAmount Valid:{}", validateTransfer.getValidateAmount());

        return transfer.getId();
    }
}
