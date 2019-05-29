package io.esev.ninja.accountssingle.service;

import io.esev.ninja.accountssingle.domain.AccountTransfer;
import io.esev.ninja.accountssingle.domain.Customer;
import io.esev.ninja.accountssingle.domain.ValidateTransfer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NotificationManager {

    @Autowired
    private CustomerService customerService;

    public static final Logger LOGGER = LoggerFactory.getLogger(NotificationManager.class);

    public String sendNotification(ValidateTransfer validateTransfer){

        LOGGER.info("*****************[2Y.2] Send Notification");
        AccountTransfer transfer = validateTransfer.getTransfer();
        Customer customer = customerService.getCustomer(transfer.getCustomerId());
        LOGGER.info("Name:{} {}", customer.getName(), customer.getLastName());
        LOGGER.info("Notification to:{}", customer.getEmail());
        LOGGER.info("AccountSource:{}", transfer.getAccountSource());
        LOGGER.info("AccountTarget:{}", transfer.getAccountTarget());
        LOGGER.info("Amount:{}", transfer.getAmount());

        return transfer.getId();
    }
}
