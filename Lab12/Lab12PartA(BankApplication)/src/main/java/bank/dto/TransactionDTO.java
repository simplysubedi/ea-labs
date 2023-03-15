package bank.dto;

public class TransactionDTO {
    private long accountNumber;
    private double amount;
private long fromAccountNumber;
private long toAccountNumber;

private String descriptionOfTransfer;
    private double amountToWithdrawEuro;

    public TransactionDTO(long accountNumber, double amount, long fromAccountNumber, long toAccountNumber, String descriptionOfTransfer, double amountToWithdrawEuro) {
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.fromAccountNumber = fromAccountNumber;
        this.toAccountNumber = toAccountNumber;
        this.descriptionOfTransfer = descriptionOfTransfer;
        this.amountToWithdrawEuro = amountToWithdrawEuro;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public long getFromAccountNumber() {
        return fromAccountNumber;
    }

    public void setFromAccountNumber(long fromAccountNumber) {
        this.fromAccountNumber = fromAccountNumber;
    }

    public long getToAccountNumber() {
        return toAccountNumber;
    }

    public void setToAccountNumber(long toAccountNumber) {
        this.toAccountNumber = toAccountNumber;
    }

    public String getDescriptionOfTransfer() {
        return descriptionOfTransfer;
    }

    public void setDescriptionOfTransfer(String descriptionOfTransfer) {
        this.descriptionOfTransfer = descriptionOfTransfer;
    }

    public double getAmountToWithdrawEuro() {
        return amountToWithdrawEuro;
    }

    public void setAmountToWithdrawEuro(double amountToWithdrawEuro) {
        this.amountToWithdrawEuro = amountToWithdrawEuro;
    }
}
