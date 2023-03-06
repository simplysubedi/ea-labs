package bank.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class TraceRecord {
    @Id
    @GeneratedValue
    private Long id;
    private LocalDate date;
    private LocalTime time;
    private String resultOfTransaction;

    public TraceRecord() {

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

    public String getResultOfTransaction() {
        return resultOfTransaction;
    }

    public void setResultOfTransaction(String resultOfTransaction) {
        this.resultOfTransaction = resultOfTransaction;
    }

    public TraceRecord(LocalDate date, LocalTime time, String resultOfTransaction) {
        this.date = date;
        this.time = time;
        this.resultOfTransaction = resultOfTransaction;
    }
}
