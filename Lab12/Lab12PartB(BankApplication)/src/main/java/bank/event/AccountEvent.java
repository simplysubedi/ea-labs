package bank.event;

public class AccountEvent {

    private long accountnumber;
    private String operation;
    private double amount;

    public AccountEvent(long accountnumber, String operation, double amount) {

        this.accountnumber = accountnumber;
        this.operation = operation;
        this.amount = amount;
    }

    public long getAccountnumber() {
        return accountnumber;
    }

    public void setAccountnumber(long accountnumber) {
        this.accountnumber = accountnumber;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
