package com.desafio.chavepix.resource;

import com.desafio.chavepix.dto.AccountDTO;
import com.desafio.chavepix.service.AccountService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/accounts")
@Api(value = "API REST")
public class AccountResource {

    @Autowired
    AccountService accountService;

    @GetMapping("/list")
    public ResponseEntity<List<AccountDTO>> listAll() {
        return ResponseEntity.ok().body(accountService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDTO> listById(@PathVariable(value = "id") Long id){
        AccountDTO accountDTO = accountService.findById(id);
        return ResponseEntity.ok(accountDTO);
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
    public ResponseEntity<AccountDTO> deleteById(@PathVariable Long id){
        accountService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
