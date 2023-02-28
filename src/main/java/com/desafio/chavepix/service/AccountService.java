package com.desafio.chavepix.service;

import com.desafio.chavepix.domain.Account;
import com.desafio.chavepix.dto.AccountDTO;
import com.desafio.chavepix.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    public List<AccountDTO> findAll(){
        List<Account> accounts = accountRepository.findAll();
        return accounts.stream().map(i -> new AccountDTO(i)).collect(Collectors.toList());
    }

    public AccountDTO findById(Long id){
        Account account = accountRepository.findById(id).get();
        AccountDTO accountDTO = new AccountDTO(account);
        return accountDTO;
    }

    public void deleteById(Long id){
        accountRepository.deleteById(id);
    }

    public AccountDTO save(AccountDTO accountDTO){
        Account account = accountDTO.convertToAccount();
        account = accountRepository.save(account);
        return new AccountDTO(account);
    }

    public AccountDTO update(Long id, AccountDTO accountDTO){
        Account account = accountRepository.getById(id);
            account.setId(accountDTO.getId());
            account.setBankName(accountDTO.getBankName());
            account.setTypeAccountEnum(accountDTO.getTypeAccountEnum());
            account.setNumAccount(accountDTO.getNumAccount());
            account.setBalanceAccount(accountDTO.getBalanceAccount());
            account.setTypeKeyEnum(accountDTO.getTypeKeyEnum());
            account.setKeyPix(accountDTO.getKeyPix());
            account = accountRepository.save(account);
            return new AccountDTO(account);
    }

}
