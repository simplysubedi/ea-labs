package accounts.repository;

import accounts.domain.Account;
import accounts.repositories.AccountRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AccountRepositoryTests {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private AccountRepository accountRepository;

    @Test
    public void when_findByAccountHolder_then_ReturnAccount(){
        Account account=new Account("56565",5600,"Bob");
        entityManager.persist(account);
        entityManager.flush();
        Account found=accountRepository.findByAccountHolder(account.getAccountHolder());
        assertThat(found.getAccountHolder()).isEqualTo(account.getAccountHolder());
    }
    @Test
    public void when_findAccountsByBalanceAndAccountNumber_then_ReturnAccount(){
        Account account=new Account("8465356",465153215,"McBord");
        entityManager.persist(account);
        entityManager.flush();
        Account found=accountRepository.findAccountsByBalanceAndAccountNumber(account.getBalance(),account.getAccountNumber());
        assertThat(found.getAccountNumber()).isEqualTo(account.getAccountNumber());
        assertThat((found.getBalance())).isEqualTo(account.getBalance());

    }
    @Test
    public void when_findAccountsByAccountNumber_then_ReturnAccount(){
        Account account = new Account("4513465413",20,"KarnBdr");
        entityManager.persist(account);
        entityManager.flush();
        Account found=accountRepository.findAccountsByAccountNumber(account.getAccountNumber());
        assertThat(found.getAccountNumber()).isEqualTo(account.getAccountNumber());
        }


}
