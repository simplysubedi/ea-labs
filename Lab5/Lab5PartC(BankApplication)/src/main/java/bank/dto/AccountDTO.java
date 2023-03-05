package bank.dto;

import bank.domain.AccountEntry;
import bank.domain.Customer;

import java.util.ArrayList;
import java.util.Collection;

public class AccountDTO {
    private long accountnumber;
    Collection<AccountEntryDTO> entryList = new ArrayList<AccountEntryDTO>();
    CustomerDTO customer;

    public long getAccountnumber() {
        return accountnumber;
    }

    public void setAccountnumber(long accountnumber) {
        this.accountnumber = accountnumber;
    }

    public Collection<AccountEntryDTO> getEntryList() {
        return entryList;
    }

    public void setEntryList(Collection<AccountEntryDTO> entryList) {
        this.entryList = entryList;
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }

    public AccountDTO(long accountnumber) {
        this.accountnumber = accountnumber;

    }
    public double getBalance() {
        double balance=0;
        for (AccountEntryDTO entry : entryList) {
            balance+=entry.getAmount();
        }
        return balance;
    }
    public AccountDTO(){};
}
