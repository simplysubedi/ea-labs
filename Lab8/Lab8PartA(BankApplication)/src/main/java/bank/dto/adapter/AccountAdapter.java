package bank.dto.adapter;

import bank.domain.Account;
import bank.dto.AccountDTO;

import java.util.ArrayList;
import java.util.List;

public class AccountAdapter {
    public static Account getAccountFromAccountDTO(AccountDTO accountDTO){
      return new Account(accountDTO.getAccountnumber());
    }
    public static AccountDTO getAccountDTOFromAccount(Account account){
       return new AccountDTO(account.getAccountnumber());
    }
    public static List<AccountDTO> getAccountDTOsFromAccounts(List<Account>accounts){
        List<AccountDTO> accountDTOs=new ArrayList<AccountDTO>();
        for(Account account:accounts){
            accountDTOs.add(getAccountDTOFromAccount(account));}
        return accountDTOs;
        }
    }
