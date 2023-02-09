package com.desafio.chavepix.domain;

import com.desafio.chavepix.enums.TypeAccountEnum;
import com.desafio.chavepix.enums.TypeKeyEnum;
import java.math.BigDecimal;

public class Account {

    private Long id;

    private TypeAccountEnum typeAccountEnum;

    private String bankName;

    private Long numAccount;

    private BigDecimal balanceAccount;

    private TypeKeyEnum typeKeyEnum;

    private String keyPix;

}
