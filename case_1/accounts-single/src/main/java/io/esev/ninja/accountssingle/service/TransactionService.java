package io.esev.ninja.accountssingle.service;

import io.esev.ninja.accountssingle.domain.AccountTransfer;
import io.esev.ninja.accountssingle.domain.ValidateTransfer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.integration.annotation.Aggregator;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TransactionService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionService.class);

    @Aggregator
    public ValidateTransfer compositeTransfer(List<ValidateTransfer> validateTransferList){
        ValidateTransfer result = new ValidateTransfer();

        result.setId(validateTransferList.get(0).getId());
        result.setTransfer(validateTransferList.get(0).getTransfer());
        result.setValidateAccount(validateTransferList.get(0).getValidateAccount());
        result.setValidateAmount(validateTransferList.get(1).getValidateAmount());

        return result;
    }

    //0, 1, 2, 3
    public String executeTransfer(AccountTransfer transfer){

        LOGGER.info("*****************[2Y.1] TransactionService.Execute:");
        LOGGER.info("AccountSource:{}", transfer.getAccountSource());
        LOGGER.info("AccountTarget:{}", transfer.getAccountTarget());
        LOGGER.info("Amount:{}", transfer.getAmount());

        return transfer.getId();
    }


    //4
//    public String executeTransfer(ValidateTransfer validateTransfer){
//
//        AccountTransfer transfer = validateTransfer.getTransfer();
//        LOGGER.info("*****************[2Y.1] TransactionService.Execute:");
//        LOGGER.info("AccountSource:{}", transfer.getAccountSource());
//        LOGGER.info("AccountTarget:{}", transfer.getAccountTarget());
//        LOGGER.info("Amount:{}", transfer.getAmount());
//
//        return transfer.getId();
//    }

}
