package com.desafio.chavepix.resource;

import com.desafio.chavepix.domain.Account;
import com.desafio.chavepix.dto.AccountDTO;
import com.desafio.chavepix.service.AccountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@SpringBootTest
public class AccountResourceTest {

    public static Long ID = 1L;
    public static  String BANK_NAME = "Itau";
    public static String PJ = "PJ";
    public static Long NUM_ACCOUNT = 2L;
    public static BigDecimal BALANCE = BigDecimal.valueOf(100.00);
    public static String TYPE_KEY = "EMAIL";
    public static String KEY = "marcus@tqi.com";

    @InjectMocks
    private AccountResource accountResource;

    @Mock
    private AccountService accountService;

    private Account account;
    private AccountDTO accountDTO;

    private void startAccount(){
        account = new Account(ID, BANK_NAME, PJ, NUM_ACCOUNT, BALANCE, TYPE_KEY, KEY);
        accountDTO = new AccountDTO(ID, BANK_NAME, PJ, NUM_ACCOUNT, BALANCE, TYPE_KEY, KEY);
    }

    @BeforeEach
    public void setup(){
        MockitoAnnotations.openMocks(this);
        startAccount();
    }

    @Test
    void whenFindByIdThenReturnSuccess(){
        // Quando chamar o método passando qualquer Long, retorna o DTO
        when(accountService.findById(anyLong())).thenReturn(accountDTO);

        ResponseEntity<AccountDTO> response = accountResource.listById(ID);

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(AccountDTO.class, response.getBody().getClass());

        assertEquals(ID, response.getBody().getId());
        assertEquals(BANK_NAME, response.getBody().getBankName());
    }

    @Test
    void whenFindAllThenReturnAllAccounts(){
        when(accountService.findAll()).thenReturn(List.of(accountDTO));

        ResponseEntity<List<AccountDTO>> response = accountResource.listAll();

        assertNotNull(response);    // Assegurar que o response não é nulo
        assertNotNull(response.getBody()); // Assegurar que o obj que vem não é nulo
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(AccountDTO.class, response.getBody().get(0).getClass()); //Verificar do obj index 0 se é um DTO

        assertEquals(ID, response.getBody().get(0).getId());
    }

    @Test
    void whenSaveThenReturnCreated(){
        when(accountService.save(any())).thenReturn(accountDTO);

        ResponseEntity<AccountDTO> response = accountResource.save(accountDTO);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(ResponseEntity.class, response.getClass());
    }

    @Test
    void whenUpdateThenReturnSuccess(){
        when(accountService.update(ID, accountDTO)).thenReturn(accountDTO);

        ResponseEntity<AccountDTO> response = accountResource.updateAccount(ID, accountDTO);

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(AccountDTO.class, response.getBody().getClass());

        assertEquals(ID, response.getBody().getId());
    }

    @Test
    void whenDeleteThenReturnSuccess(){
        doNothing().when(accountService).deleteById(anyLong());

        ResponseEntity<AccountDTO> response = accountResource.deleteById(ID);

        assertNotNull(response);
        assertEquals(ResponseEntity.class, response.getClass());
        verify(accountService, times(1)).deleteById(anyLong());
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }

}
