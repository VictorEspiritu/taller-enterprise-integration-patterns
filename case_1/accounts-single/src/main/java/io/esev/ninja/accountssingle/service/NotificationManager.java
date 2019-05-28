package io.esev.ninja.accountssingle.service;

import io.esev.ninja.accountssingle.domain.ValidateTransaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class NotificationManager {

    public static final Logger LOGGER = LoggerFactory.getLogger(NotificationManager.class);

    public String sendNotification(ValidateTransaction transaction){

        LOGGER.info("*****************[2Y.2] Send Notification");
        LOGGER.info("Template: {}", transaction.getTransaction());

        return transaction.getId();
    }
}
