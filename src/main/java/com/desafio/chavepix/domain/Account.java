package com.desafio.chavepix.domain;

import com.desafio.chavepix.enums.TypeAccountEnum;
import com.desafio.chavepix.enums.TypeKeyEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "account")
public class Account implements Serializable {

    private static final long serialVersionUID = -8985397890752995777L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_account")
    private Long id;

    @Column(name = "bank_name")
    private String bankName;

    //@Enumerated(EnumType.STRING)
    @Column(name = "type_account")
    private String typeAccountEnum;

    @Column(name = "num_account")
    private Long numAccount;

    @Column(name = "balance_account")
    private BigDecimal balanceAccount;

    //@Enumerated(EnumType.STRING)
    @Column(name = "type_key")
    private String typeKeyEnum;

    @Column(name = "key_pix")
    private String keyPix;

}
