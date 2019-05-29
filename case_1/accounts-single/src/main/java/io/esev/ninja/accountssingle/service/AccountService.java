package io.esev.ninja.accountssingle.service;

import io.esev.ninja.accountssingle.domain.Account;
import io.esev.ninja.accountssingle.domain.AccountTransfer;
import io.esev.ninja.accountssingle.domain.ValidateTransfer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AccountService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountService.class);

    private static Map<String, Account> accounts;

    static {
        accounts = new HashMap<>();
        accounts.put("011-0199-0321374154",new Account("011-0199-0321374154", 1000.00, 1));
        accounts.put("012-0760-0200374154",new Account("011-0760-0200374154", 2000.00, 1));
        accounts.put("013-0199-0212323333",new Account("011-0199-0212323333", 1500.00, 2));
        accounts.put("014-0199-0766565454",new Account("011-0199-0766565454", 3000.00, 3));
        accounts.put("015-0199-0345345455",new Account("011-0199-0345345455", 5000.00, 1));
        accounts.put("016-0760-0564423422",new Account("011-0760-0564423422", 2500.00, 2));
    }

    public Account getAccount(String account){

        return accounts.get(account);
    }

    public List<Account> getAccount(){
        return new ArrayList<>(accounts.values());
    }

    public ValidateTransfer validateAmount(AccountTransfer transfer){

        LOGGER.info("*****************[1.1] Validate Mount");
        ValidateTransfer validate = new ValidateTransfer(transfer);
        validate.setValidateAmount(getAccount(transfer.getAccountSource()).getBalance() >= transfer.getAmount());

        return validate;
    }
}
