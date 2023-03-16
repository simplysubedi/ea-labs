import bank.domain.Account;
import bank.domain.Customer;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.equalTo;

public class AccountTest {
    @Test
    public void testIncrement() {
        Account account = new Account();
        account.deposit(100.0);
        assertThat(account.getBalance(), closeTo(100.0, 0.01));
    }

    @Test
    public void testSetCustomer() {
        Account account = new Account(25343);
        account.setCustomer(new Customer("Tranky"));
        assertThat(account.getCustomer().getName(), equalTo("Tranky"));
    }

    @Test
    public void testSetAccountNumber() {
        Account account = new Account();
        account.setAccountnumber(25343L);
        assertThat(account.getAccountnumber(), equalTo(25343L));
    }

    @Test
    public void depositAmountTest() {
        Account account = new Account();
        account.deposit(56.0);
        assertThat(account.getBalance(), closeTo(56.0, 0.01));
    }

    @Test
    public void testWithdraw() {
        Account account = new Account();
        account.withdraw(585.0);
        assertThat(account.getBalance(), equalTo(-585.0));
    }

    @Test
    public void testTransfer() {
        Account fromAccount = new Account(53553);
        fromAccount.setCustomer(new Customer("Spectre"));
        Account toAccount = new Account(78657655);
        toAccount.setCustomer(new Customer("Rachel"));
        fromAccount.transferFunds(toAccount, 56.0, "Loan re-payment");
        assertThat(fromAccount.getBalance(), equalTo(-56.0));
        assertThat(toAccount.getBalance(), equalTo(56.0));
    }
}
