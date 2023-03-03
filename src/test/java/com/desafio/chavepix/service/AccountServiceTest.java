package com.desafio.chavepix.service;

import com.desafio.chavepix.domain.Account;
import com.desafio.chavepix.dto.AccountDTO;
import com.desafio.chavepix.repository.AccountRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AccountServiceTest {

    public static Long ID = 4L;
    public static  String BANK_NAME = "Pagseguro";
    public static String PJ = "PJ";
    public static Long NUM_ACCOUNT = 12345L;
    public static BigDecimal BALANCE = BigDecimal.valueOf(100.00);
    public static String TYPE_KEY = "EMAIL";
    public static String KEY = "marcus@tqi.com.br";

    private void startAccount(){
        account = new Account(ID, BANK_NAME, PJ, NUM_ACCOUNT, BALANCE, TYPE_KEY, KEY);
    }

    @InjectMocks
    AccountService accountService;

    @Mock
    AccountRepository accountRepository;

    private Account account;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        startAccount();
    }

    @Test
    public void whenFindAllThenReturnAnList(){
        when(accountRepository.findAll()).thenReturn(List.of(account));

        List<AccountDTO> response = accountService.findAll();

        Assertions.assertNotNull(response);
        Assertions.assertEquals(1, response.size());
        Assertions.assertEquals(AccountDTO.class, response.get(0).getClass()); // Assegurar que o obj do index 0 seja = classe AccountDTO
        Assertions.assertEquals(ID, response.get(0).getId());
    }

    @Test
    public void testFindById(){
        when(accountRepository.findById(ID)).thenReturn(Optional.of(account));

        AccountDTO response = accountService.findById(ID);

        Assertions.assertNotNull(response);
        Assertions.assertEquals(AccountDTO.class, response.getClass());
        Assertions.assertEquals(ID, response.getId());
        Assertions.assertEquals(BANK_NAME, response.getBankName());
    }

}
