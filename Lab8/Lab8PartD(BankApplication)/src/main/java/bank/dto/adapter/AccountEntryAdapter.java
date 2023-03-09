package bank.dto.adapter;

import bank.domain.AccountEntry;
import bank.dto.AccountEntryDTO;

import java.util.ArrayList;
import java.util.List;

public class AccountEntryAdapter {
    public static AccountEntry getAccountFromAccountDTO(AccountEntryDTO accountEntryDTO){
      return new AccountEntry(accountEntryDTO.getDate(), accountEntryDTO.getAmount(), accountEntryDTO.getDescription(), accountEntryDTO.getFromAccountNumber(), accountEntryDTO.getFromPersonName());
    }
    public static AccountEntryDTO getAccountDTOFromAccount(AccountEntry accountEntry){
       return new AccountEntryDTO(accountEntry.getDate(), accountEntry.getAmount(), accountEntry.getDescription(), accountEntry.getFromPersonName(), accountEntry.getFromPersonName());
    }
    public static List<AccountEntryDTO> getAccountDTOsFromAccounts(List<AccountEntry>accounts){
        List<AccountEntryDTO> accountDTOs=new ArrayList<AccountEntryDTO>();
        for(AccountEntry AccountEntry:accounts){
            accountDTOs.add(getAccountDTOFromAccount(AccountEntry));}
        return accountDTOs;
        }
    }
