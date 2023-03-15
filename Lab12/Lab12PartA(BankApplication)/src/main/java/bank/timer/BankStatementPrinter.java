package bank.timer;

import bank.dto.AccountDTO;
import bank.dto.AccountRequestDTO;
import bank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Timer;
import java.util.TimerTask;

@Component
public class BankStatementPrinter  {
@Autowired
    private AccountService accountService;

    @Scheduled(fixedRate = 20000)
    public void getAllAccountsAtInterval() {
        System.out.println(accountService.getAllAccounts());

    }
}
