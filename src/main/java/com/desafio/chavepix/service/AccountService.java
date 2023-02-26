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

    // LISTAR TODAS CONTAS
    public List<AccountDTO> findAll(){
        List<Account> accounts = accountRepository.findAll();
        return accounts.stream().map(i -> new AccountDTO(i)).collect(Collectors.toList());
    }

    // DELETAR CONTA POR ID
    public void deleteById(Long id){
        accountRepository.deleteById(id);
    }

    // FAZER ALTERAÇÕES PARA O CRUD PIX

}
