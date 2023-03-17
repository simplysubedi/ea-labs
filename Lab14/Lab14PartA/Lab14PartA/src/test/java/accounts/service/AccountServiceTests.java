package accounts.service;

import accounts.domain.Account;
import accounts.repositories.AccountRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
public class AccountServiceTests {
    @TestConfiguration
    static class AccountServiceTestContextConfiguration {
        @Bean
        public AccountService accountService() {
            return new AccountService();
        }
    }

    @Autowired
    private AccountService accountService;
    @MockBean
    private AccountRepository accountRepository;

    @Before
    public void setUp() {
        Account account = new Account("46532135", 5600, "Frank Brown");
        Optional<Account> frankOptional = Optional.of(account);
        Mockito.when(accountRepository.findById("46532135"))
                .thenReturn(frankOptional);
    }

    @Test
    public void whenValidAccountNumberThenAccountShouldBeFound() {
        AccountDTO found = accountService.getAccount("46532135");
        assertThat(found.getAccountNumber())
                .isEqualTo("46532135");
        assertThat(found.getAccountHolder())
                .isEqualTo("Frank Brown");
        assertThat(found.getBalance())
                .isEqualTo(5600);
    }
    @Test
    public void whenAccountCreatedAccountNumberShouldBeFound(){
        String accountNumber="46532135";
        accountService.createAccount(accountNumber,5600,"Frank Brown");
        assertThat(accountService.getAccount(accountNumber).getAccountNumber()).isEqualTo(accountNumber);
    }
}
