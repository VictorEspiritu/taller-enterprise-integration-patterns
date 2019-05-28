package io.esev.ninja.accountssingle.service;

import io.esev.ninja.accountssingle.domain.Transaction;
import io.esev.ninja.accountssingle.domain.ValidateTransaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.integration.annotation.Aggregator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionService.class);

//    public String execute(Transaction transaction){
    public String execute(ValidateTransaction transaction){

        LOGGER.info("*****************[2Y.1] TransactionService.Execute:");
        LOGGER.info("Tx V: {}", transaction);

        return transaction.toString();
    }

    @Aggregator
    public ValidateTransaction compositeTx(List<ValidateTransaction> validations){
        ValidateTransaction result = new ValidateTransaction();

        result.setId(validations.get(0).getId());
        result.setTransaction(validations.get(0).getTransaction());
        result.setValidateAccount(validations.get(0).isValidateAccount());
        result.setValidateAmount(validations.get(1).isValidateAmount());

        return result;
    }
}
