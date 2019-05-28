package io.esev.ninja.accountssingle.domain;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String id;
    private String name;
    private String lastName;
    private String email;
    private List<Account> accounts;

    public Customer() {
        super();
    }

    public Customer(String id, String name, String lastName, String email) {
        this.setId(id);
        this.setName(name);
        this.setLastName(lastName);
        this.setEmail(email);
        this.setAccounts(new ArrayList<>());
    }

    public Customer(String id, String name, String lastName, String email, List<Account> accounts) {
        this.setId(id);
        this.setName(name);
        this.setLastName(lastName);
        this.setEmail(email);
        this.setAccounts(accounts);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Customer{");
        sb.append("id='").append(id).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", accounts=").append(accounts);
        sb.append('}');
        return sb.toString();
    }
}
