package com.desafio.chavepix.resource;

import com.desafio.chavepix.domain.Account;
import com.desafio.chavepix.dto.AccountDTO;
import com.desafio.chavepix.repository.AccountRepository;
import com.desafio.chavepix.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/accounts")
public class AccountResource {

    @Autowired
    AccountService accountService;

    @GetMapping("/list")
    public List<AccountDTO> listAll() {
        return accountService.findAll();
    }

//    @PostMapping("/save")
//    public Account save(@RequestBody Account account) {
//        return accountService.save(account);
//    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id")Long id){
        accountService.deleteById(id);
    }

}
