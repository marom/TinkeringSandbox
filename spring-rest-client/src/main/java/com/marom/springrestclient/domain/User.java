
package com.marom.springrestclient.domain;

import lombok.Data;

@Data
public class User {

    public String gender;
    public Name name;
    public Location location;
    public String email;
    public Login login;
    public String phone;
    public Job job;
    public Billing billing;
    public String language;
    public String currency;

}
