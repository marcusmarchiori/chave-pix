package com.desafio.chavepix.resources;

import com.desafio.chavepix.domain.Account;
import com.desafio.chavepix.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/accounts")
public class AccountResource {

    @Autowired
    AccountRepository accountRepository;

    @GetMapping("/list")
    public List<Account> listAll() {
        return accountRepository.findAll();
    }

    @PostMapping("/save")
    public Account save(@RequestBody Account account) {
        return accountRepository.save(account);
    }

}
