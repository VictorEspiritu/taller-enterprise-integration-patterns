package io.esev.ninja.accountssingle.domain;

public class ValidateTransaction {

    private String id;
    private Boolean validateAccount;
    private Boolean validateAmount;
    private Transaction transaction;

    public ValidateTransaction() {
        super();
    }

    public ValidateTransaction(Transaction transaction) {
        super();
        this.setId(transaction.getId());
        this.setTransaction(transaction);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean isValidateAccount() {
        return validateAccount;
    }

    public void setValidateAccount(boolean validateAccount) {
        this.validateAccount = validateAccount;
    }

    public Boolean isValidateAmount() {
        return validateAmount;
    }

    public void setValidateAmount(boolean validateAmount) {
        this.validateAmount = validateAmount;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public Boolean validTransaction(){
        return validateAccount && validateAmount;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ValidateTransaction{");
        sb.append("id='").append(id).append('\'');
        sb.append(", validateAccount=").append(validateAccount);
        sb.append(", validateAmount=").append(validateAmount);
        sb.append(", transaction=").append(transaction);
        sb.append('}');
        return sb.toString();
    }
}
