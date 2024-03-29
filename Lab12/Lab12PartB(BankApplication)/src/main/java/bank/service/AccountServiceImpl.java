package bank.service;

import bank.domain.Account;
import bank.domain.AccountEntry;
import bank.domain.Customer;
import bank.dto.AccountDTO;
import bank.dto.adapter.AccountAdapter;
import bank.dto.adapter.AccountEntryAdapter;
import bank.dto.adapter.CustomerAdapter;
import bank.event.AccountEvent;
import bank.event.MailEvent;
import bank.jms.JMSSender;
import bank.jms.TaxServiceJMSSenderImpl;
import bank.logging.Logger;
import bank.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@EnableAsync
@Transactional

public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private CurrencyConverter currencyConverter;
	@Autowired
	private JMSSender jmsSender;
	@Autowired
	private Logger logger;
@Autowired
private TaxServiceJMSSenderImpl taxServiceJMSSender;

@Autowired
private ApplicationEventPublisher eventPublisher;
	public AccountDTO createAccount(long accountNumber, String customerName) {
		Account account = new Account(accountNumber);
		Customer customer = new Customer(customerName);
		AccountDTO accountDTO = AccountAdapter.getAccountDTOFromAccount(account);
		accountDTO.setCustomer(CustomerAdapter.getCustomerDTOFromCustomer(customer));
		account.setCustomer(customer);
		accountRepository.save(account);
		
		logger.log("createAccount with parameters accountNumber= "+accountNumber+" , customerName= "+customerName);
		return accountDTO;
	}

		@Async
	public void deposit(long accountNumber, double amount) {
		Account account = accountRepository.findByAccountnumber(accountNumber);
		account.deposit(amount);
		accountRepository.save(account);
		logger.log("deposit with parameters accountNumber= "+accountNumber+" , amount= "+amount);
		if (amount > 10000){
			jmsSender.sendJMSMessage("Deposoit of $ "+amount+ " to account with accpount number "+accountNumber);
		}
		eventPublisher.publishEvent(new AccountEvent(accountNumber,"deposit",amount));
			eventPublisher.publishEvent(new MailEvent());
	}

	public AccountDTO getAccount(long accountNumber) {
		Account account = accountRepository.findByAccountnumber(accountNumber);
		return AccountAdapter.getAccountDTOFromAccount(account);
	}

	public Collection<AccountDTO> getAllAccounts() {
		List<Account> accounts = accountRepository.findAll();
		Collection<AccountDTO> accountDTOS = new ArrayList<>();
		for (Account account:accounts){
			AccountDTO accountDTO = AccountAdapter.getAccountDTOFromAccount(account);
			accountDTO.setCustomer(CustomerAdapter.getCustomerDTOFromCustomer(account.getCustomer()));
			accountDTO.setEntryList(AccountEntryAdapter.getAccountDTOsFromAccounts((List<AccountEntry>) account.getEntryList()));
			accountDTOS.add(accountDTO);
		}
		return accountDTOS;
	}
	@Async
	public void withdraw(long accountNumber, double amount) {
		Account account = accountRepository.findByAccountnumber(accountNumber);
		account.withdraw(amount);
		accountRepository.save(account);
		logger.log("withdraw with parameters accountNumber= "+accountNumber+" , amount= "+amount);
		eventPublisher.publishEvent(new AccountEvent(accountNumber,"withdraw",amount));
		eventPublisher.publishEvent(new MailEvent());
	}
	@Async
	public void depositEuros(long accountNumber, double amount) {

		Account account = accountRepository.findByAccountnumber(accountNumber);
		double amountDollars = currencyConverter.euroToDollars(amount);
		account.deposit(amountDollars);
		accountRepository.save(account);
		logger.log("depositEuros with parameters accountNumber= "+accountNumber+" , amount= "+amount);
		if (amountDollars > 10000){
			taxServiceJMSSender.sendDepositJMSMessage("Deposit of Euro "+amount+" to account with accountNumber= "+accountNumber);
		}
		eventPublisher.publishEvent(new AccountEvent(accountNumber,"depositEuro",amount));
		eventPublisher.publishEvent(new MailEvent());

	}
	@Async
	public void withdrawEuros(long accountNumber, double amount) {
		Account account = accountRepository.findByAccountnumber(accountNumber);
		double amountDollars = currencyConverter.euroToDollars(amount);
		account.withdraw(amountDollars);
		accountRepository.save(account);
		logger.log("withdrawEuros with parameters accountNumber= "+accountNumber+" , amount= "+amount);
		eventPublisher.publishEvent(new AccountEvent(accountNumber,"withdrawEuro",amount));
		eventPublisher.publishEvent(new MailEvent());

	}

	public void transferFunds(long fromAccountNumber, long toAccountNumber, double amount, String description) {
		Account fromAccount = accountRepository.findByAccountnumber(fromAccountNumber);
		Account toAccount = accountRepository.findByAccountnumber(toAccountNumber);
		fromAccount.transferFunds(toAccount, amount, description);
		accountRepository.save(fromAccount);
		accountRepository.save(toAccount);
		logger.log("transferFunds with parameters fromAccountNumber= "+fromAccountNumber+" , toAccountNumber= "+toAccountNumber+" , amount= "+amount+" , description= "+description);
		if (amount > 10000){
			jmsSender.sendJMSMessage("TransferFunds of $ "+amount+" from account with accountNumber= "+fromAccount+" to account with accountNumber= "+toAccount);
		}
		eventPublisher.publishEvent(new MailEvent());
	}
}
