package bank.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class TraceRecord {
    @Id
    @GeneratedValue
    private int id;
    private long accountnumber;
    private String operation;
    private double amount;
private LocalDate date;
private LocalTime time;
    public TraceRecord(long accountnumber, String operation, double amount) {

        this.accountnumber = accountnumber;
        this.operation = operation;
        this.amount = amount;
    }

    public TraceRecord(int id, long accountnumber, String operation, double amount, LocalDate date, LocalTime time) {
        this.id = id;
        this.accountnumber = accountnumber;
        this.operation = operation;
        this.amount = amount;
        this.date = date;
        this.time = time;
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

    public TraceRecord() {
    }

    public TraceRecord(long accountnumber, String operation, double amount, LocalDate date, LocalTime time) {
        this.accountnumber = accountnumber;
        this.operation = operation;
        this.amount = amount;
        this.date = date;
        this.time = time;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
}
