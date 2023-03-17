package accounts.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import accounts.domain.Account;
import org.springframework.stereotype.Repository;

@Repository

public interface AccountRepository extends JpaRepository<Account, String>{
   public Account findByAccountHolder(String accountHolder);
   public Account findAccountsByBalanceAndAccountNumber(Double balance,String accountNumber);
   public Account findAccountsByAccountNumber(String accountNumber);
}
