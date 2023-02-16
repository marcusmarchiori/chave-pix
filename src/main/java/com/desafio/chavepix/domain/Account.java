package com.desafio.chavepix.domain;

import com.desafio.chavepix.enums.TypeAccountEnum;
import com.desafio.chavepix.enums.TypeKeyEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_account")
    private Long id;

    @Column(name = "type_account")
    private TypeAccountEnum typeAccountEnum;

    @Column(name = "bank_name")
    private String bankName;

    @Column(name = "num_account")
    private Long numAccount;

    @Column(name = "balance_account")
    private BigDecimal balanceAccount;

    @Column(name = "type_key")
    private TypeKeyEnum typeKeyEnum;

    @Column(name = "key_pix")
    private String keyPix;

}
