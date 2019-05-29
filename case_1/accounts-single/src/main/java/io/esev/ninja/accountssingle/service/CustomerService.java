package io.esev.ninja.accountssingle.service;

import io.esev.ninja.accountssingle.domain.Account;
import io.esev.ninja.accountssingle.domain.AccountTransfer;
import io.esev.ninja.accountssingle.domain.Customer;
import io.esev.ninja.accountssingle.domain.ValidateTransfer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustomerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);

    private static Map<String, Customer> customers;

    static {
        customers = new HashMap<>();
        Account a1 = new Account("011-0199-0321374154", 1000.00, 1);
        Account a2 = new Account("012-0760-0200374154", 2000.00, 1);
        Account a3 = new Account("013-0199-0212323333", 1500.00, 2);
        Account a4 = new Account("014-0199-0766565454", 3000.00, 3);
        Account a5 = new Account("015-0199-0345345455", 5000.00, 1);
        Account a6 = new Account("016-0760-0564423422", 2500.00, 2);

        customers.put("1", new Customer("1","Victor", "Espiritu", "victor.espiritu@bbva.com", Arrays.asList(a1, a2, a3)));
        customers.put("2", new Customer("2","Erick", "Santiago", "erick.santiago@bbva.com", Arrays.asList(a4, a5)));
        customers.put("3", new Customer("3","Maria", "Galvez", "maria.galvez@bbva.com", Arrays.asList(a6)));
    }

    public List<Customer> getCustomers(){
        return new ArrayList<>(customers.values());
    }

    public Customer getCustomer(String customerId){
        return customers.get(customerId);
    }

    public ValidateTransfer validateAccountOwn(AccountTransfer transfer){

        LOGGER.info("*****************[1.2] Validate Account Own");
        Customer customer = customers.get(transfer.getCustomerId());
        ValidateTransfer validate = new ValidateTransfer(transfer);
        validate.setValidateAccount(customer.getAccounts().stream().filter( a -> a.getAccount() == transfer.getAccountSource() ).findFirst().get() != null);

        return validate;
    }

}
