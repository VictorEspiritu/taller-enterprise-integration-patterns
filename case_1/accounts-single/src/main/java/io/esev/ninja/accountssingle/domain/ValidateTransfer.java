package io.esev.ninja.accountssingle.domain;

public class ValidateTransfer {

    private String id;
    private Boolean validateAccount;
    private Boolean validateAmount;
    private AccountTransfer transfer;

    public ValidateTransfer() {
        super();
    }

    public ValidateTransfer(AccountTransfer transfer) {
        super();
        this.setId(transfer.getId());
        this.setTransfer(transfer);
    }

    public Boolean isValidTransfer(){
        return validateAccount && validateAmount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getValidateAccount() {
        return validateAccount;
    }

    public void setValidateAccount(Boolean validateAccount) {
        this.validateAccount = validateAccount;
    }

    public Boolean getValidateAmount() {
        return validateAmount;
    }

    public void setValidateAmount(Boolean validateAmount) {
        this.validateAmount = validateAmount;
    }

    public AccountTransfer getTransfer() {
        return transfer;
    }

    public void setTransfer(AccountTransfer transfer) {
        this.transfer = transfer;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ValidateTransfer{");
        sb.append("id='").append(id).append('\'');
        sb.append(", validateAccount=").append(validateAccount);
        sb.append(", validateAmount=").append(validateAmount);
        sb.append(", transfer=").append(transfer);
        sb.append('}');
        return sb.toString();
    }
}
