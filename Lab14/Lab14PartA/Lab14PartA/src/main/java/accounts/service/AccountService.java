package accounts.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import accounts.domain.Account;
import accounts.repositories.AccountRepository;

@Service
public class AccountService {
	@Autowired
	AccountRepository repository;
		
	public AccountDTO getAccount(String accountNumber) {
		Optional<Account> accountOptional = repository.findById(accountNumber);
		if (accountOptional.isPresent()) {
			Account account = accountOptional.get();
			AccountDTO accountDto = AccountAdapter.getAccountDto(account);
			return accountDto;
		}
		return null;
	}
	
	public void createAccount(String accountNumber, double amount, String accountHolder) {
		repository.save(new Account(accountNumber, amount, accountHolder));
	}
	

}
