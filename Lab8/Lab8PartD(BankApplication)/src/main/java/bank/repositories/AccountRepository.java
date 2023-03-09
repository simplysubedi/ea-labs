package bank.repositories;

import bank.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountRepository extends MongoRepository<Account,String> {
    Account findByAccountnumber(long accountNumber);
}
