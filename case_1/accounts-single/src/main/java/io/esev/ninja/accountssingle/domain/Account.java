package io.esev.ninja.accountssingle.domain;

import java.util.UUID;

public class Account {

    private String id;
    private String account;
    private double balance;
    private int type;           // 1-> Simple Account, 2-> Savings Account, 3-> Winning Account

    public Account() {
        super();
    }

    public Account(String account, double balance, int type) {
        super();
        this.setId(UUID.randomUUID().toString());
        this.setAccount(account);
        this.setBalance(balance);
        this.setType(type);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Account{");
        sb.append("id='").append(id).append('\'');
        sb.append(", account='").append(account).append('\'');
        sb.append(", balance=").append(balance);
        sb.append(", type=").append(type);
        sb.append('}');
        return sb.toString();
    }
}
