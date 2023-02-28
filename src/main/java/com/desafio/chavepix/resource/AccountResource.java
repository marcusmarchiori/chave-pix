package com.desafio.chavepix.resource;

import com.desafio.chavepix.domain.Account;
import com.desafio.chavepix.dto.AccountDTO;
import com.desafio.chavepix.repository.AccountRepository;
import com.desafio.chavepix.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/list/{id}")
    public AccountDTO listById(@PathVariable(value = "id") Long id){
        return accountService.findById(id);
    }


    @PostMapping("/save")
    public ResponseEntity<AccountDTO> save(@RequestBody AccountDTO accountDTO){
        accountDTO = accountService.save(accountDTO);
        return new ResponseEntity<>(accountDTO, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<AccountDTO> updateAccount(@PathVariable Long id,
                                                    @RequestBody AccountDTO accountDTO){
        accountDTO = accountService.update(id, accountDTO);
        return ResponseEntity.ok().body(accountDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id")Long id){
        accountService.deleteById(id);
    }

}
