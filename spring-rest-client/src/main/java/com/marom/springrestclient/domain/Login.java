
package com.marom.springrestclient.domain;

import lombok.Data;

@Data
public class Login {

    public String username;
    public String password;
    public String md5;
    public String sha1;
    public String sha256;

}
