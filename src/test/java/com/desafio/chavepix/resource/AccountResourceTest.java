package com.desafio.chavepix.resource;

import com.desafio.chavepix.domain.Account;
import com.desafio.chavepix.dto.AccountDTO;
import com.desafio.chavepix.service.AccountService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

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
        when(accountService.findById(anyLong())).thenReturn(accountDTO);

        ResponseEntity<AccountDTO> response = accountResource.listById(ID);

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(AccountDTO.class, response.getBody().getClass());
    }

//    @Test
//    public void returnSuccess(){
//
//        when(this.accountService.findById(2L))
//                .thenReturn(new AccountDTO(ID, BANK_NAME, PJ, NUM_ACCOUNT, BALANCE, TYPE_KEY, KEY));
//
//        // Fornecer infos para o teste
//        RestAssuredMockMvc.given()
//                .accept(ContentType.JSON)
//        .when()
//                .get("/accounts/{id}", 2L)
//        .then()
//                .statusCode(HttpStatus.OK.value());
//    }
//
}
