package com.desafio.chavepix.dto;

import com.desafio.chavepix.domain.Account;
import com.desafio.chavepix.enums.TypeAccountEnum;
import com.desafio.chavepix.enums.TypeKeyEnum;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountDTO {

    private Long id;

    private String bankName;

    private TypeAccountEnum typeAccountEnum;

    private Long numAccount;

    private BigDecimal balanceAccount;

    private TypeKeyEnum typeKeyEnum;

    private String keyPix;

    public Account convertToAccount(){
        return new Account(id, bankName, typeAccountEnum, numAccount,
                balanceAccount, typeKeyEnum, keyPix);
    }

    public AccountDTO(Account account) {
        id = account.getId();
        bankName = account.getBankName();
        typeAccountEnum = account.getTypeAccountEnum();
        numAccount = account.getNumAccount();
        balanceAccount = account.getBalanceAccount();
        typeKeyEnum = account.getTypeKeyEnum();
        keyPix = account.getKeyPix();
    }
}