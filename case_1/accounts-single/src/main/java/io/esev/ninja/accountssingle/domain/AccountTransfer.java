package io.esev.ninja.accountssingle.domain;

import java.util.UUID;

public class AccountTransfer {

    private String id;
    private String customerId;
    private String accountSource;
    private String accountTarget;
    private double amount;

    public AccountTransfer() {
        super();
    }

    public AccountTransfer(String customerId, String accountSource, String accountTarget, double amount) {
        this.setId(UUID.randomUUID().toString());
        this.setCustomerId(customerId);
        this.setAccountSource(accountSource);
        this.setAccountTarget(accountTarget);
        this.setAmount(amount);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getAccountSource() {
        return accountSource;
    }

    public void setAccountSource(String accountSource) {
        this.accountSource = accountSource;
    }

    public String getAccountTarget() {
        return accountTarget;
    }

    public void setAccountTarget(String accountTarget) {
        this.accountTarget = accountTarget;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Transaction{");
        sb.append("id='").append(id).append('\'');
        sb.append(", customerId='").append(customerId).append('\'');
        sb.append(", accountSource='").append(accountSource).append('\'');
        sb.append(", accountTarget='").append(accountTarget).append('\'');
        sb.append(", amount=").append(amount);
        sb.append('}');
        return sb.toString();
    }
}
