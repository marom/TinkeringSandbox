
package com.marom.springrestclient.domain;

import lombok.Data;

@Data
public class Card {

    public String type;
    public String number;
    public ExpirationDate expirationDate;
    public String iban;
    public String swift;

}
