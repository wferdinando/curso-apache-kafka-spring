package com.wferdinando.jsonconsumer.model;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Payment {
    
    private Long id;
    private Long idUser;
    private Long idProduct;
    private String cardNumber;
}
