package com.desafio.chavepix.resource;

import com.desafio.chavepix.dto.AccountDTO;
import com.desafio.chavepix.service.AccountService;
import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import static org.mockito.Mockito.*;

@WebMvcTest
public class AccountResourceTest {

    @Autowired
    private AccountResource accountResource;

    @MockBean
    private AccountService accountService;

    @BeforeEach
    public void setup(){
        RestAssuredMockMvc.standaloneSetup(this.accountResource);
    }

    @Test
    public void returnSuccess(){

        when(this.accountService.findById(2L))
                .thenReturn(new AccountDTO());

        // Fornecer infos para o teste
        RestAssuredMockMvc.given()
                .accept(ContentType.JSON)
        .when()
                .get("/accounts/{id}", 2L)
        .then()
                .statusCode(HttpStatus.OK.value());
    }

}
