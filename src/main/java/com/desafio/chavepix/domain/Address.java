package com.desafio.chavepix.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

public class Address {

    private Long id;

    private String street;

    private String number;

    private String complement;

    private String neighborhood;

    private String city;

    private String state;

}
