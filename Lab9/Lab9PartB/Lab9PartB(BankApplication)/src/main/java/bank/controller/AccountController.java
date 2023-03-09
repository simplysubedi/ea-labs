package bank.controller;
import bank.domain.Account;
import bank.dto.AccountDTO;
import bank.dto.AccountRequestDTO;
import bank.dto.TransactionDTO;
import bank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    AccountService accountService;

    //    public AccountDTO createAccount(long accountNumber, String customerName);
    @PostMapping()
    public ResponseEntity<?> createAccount(@RequestBody AccountRequestDTO accountRequestDTO) {
        accountService.createAccount(accountRequestDTO.getAccountNumber(), accountRequestDTO.getName());
        return new ResponseEntity<String>("Account for " + accountRequestDTO.getName() + " with Account Number " + accountRequestDTO.getAccountNumber() + " is created.", HttpStatus.OK);
    }

    //    public Collection<AccountDTO> getAllAccounts();
    @GetMapping()
    public ResponseEntity<?> getAllAccounts() {
        return (new ResponseEntity<Collection<AccountDTO>>(accountService.getAllAccounts(), HttpStatus.OK));
    }

    //    public void deposit (long accountNumber, double amount);
    @PostMapping("/transaction/deposit/{accountNumber}")
    public ResponseEntity<?> deposit(@PathVariable long accountNumber, @RequestBody TransactionDTO transactionDTO) {
        accountService.deposit(accountNumber, transactionDTO.getAmount());
        return new ResponseEntity<String>("Amount " + transactionDTO.getAmount() + " is deposited in Account number: " + accountNumber + ".", HttpStatus.OK);

    }

    //    public void depositEuros (long accountNumber, double amount);
    @PostMapping("/transaction/depositineuro/{accountNumber}")
    public ResponseEntity<?> depositInEuro(@PathVariable long accountNumber, @RequestBody TransactionDTO transactionDTO) {
        accountService.deposit(accountNumber, transactionDTO.getAmount());
        return new ResponseEntity<String>("Amount " + transactionDTO.getAmount() + " Euro is deposited in  Account number: " + accountNumber + ".", HttpStatus.OK);
    }
    //    public void withdraw(long accountNumber, double amount);
    @PostMapping("/transaction/withdraw/{accountNumber}")
    public ResponseEntity<?> withdraw(@PathVariable long accountNumber, @RequestBody TransactionDTO transactionDTO) {
        accountService.withdraw(accountNumber, transactionDTO.getAmount());
        return new ResponseEntity<String>("Amount " + transactionDTO.getAmount() + " is withdrawn from  Account number: " + accountNumber + ".", HttpStatus.OK);
    }
//    public void withdrawEuros (long accountNumber, double amount);
        @PostMapping("/transaction/withdrawineuro/{accountNumber}")
        public ResponseEntity<?> withdrawEuros(@PathVariable long accountNumber, @RequestBody TransactionDTO transactionDTO) {
            accountService.withdrawEuros(accountNumber, transactionDTO.getAmountToWithdrawEuro());
            return new ResponseEntity<String>("Amount " + transactionDTO.getAmount() + " Euro is withdrawn from  Account number: " + accountNumber + ".", HttpStatus.OK);
        }
//    public void transferFunds(long fromAccountNumber, long toAccountNumber, double amount, String description);

    @PostMapping("/transaction/transfer/{accountNumber}")
    public ResponseEntity<?> transfer(@PathVariable long accountNumber, @RequestBody TransactionDTO transactionDTO) {
        accountService.transferFunds(accountNumber,transactionDTO.getToAccountNumber(), transactionDTO.getAmount(),transactionDTO.getDescriptionOfTransfer());
        return new ResponseEntity<String>("Amount " + transactionDTO.getAmount() + "  is transferred from accountNumber:"+accountNumber +" to accountNumber:"+transactionDTO.getToAccountNumber()+" with description " +transactionDTO.getDescriptionOfTransfer()+ ".", HttpStatus.OK);
    }
}