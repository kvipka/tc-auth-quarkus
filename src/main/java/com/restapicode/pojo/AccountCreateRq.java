package com.restapicode.pojo;

import javax.validation.constraints.NotNull;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

public class AccountCreateRq {
    @Schema(required = true, description = "Account username")
    @NotNull(message = "account_name does not exist")
    private String account_name;
    @Schema(required = true, description = "Account password")
    @NotNull(message = "account_password does not exist")
    private String account_password;
    @Schema(required = true, description = "Account email")
    @NotNull(message = "account_email does not exist")
    private String account_email;

    public String getAccount_name() {
        return account_name;
    }

    public String getAccount_password() {
        return account_password;
    }

    public String getAccount_email() {
        return account_email;
    }

    @Override
    public String toString() {
        return "AccountCreateRq{" +
                "account_name='" + account_name + '\'' +
                ", account_password='" + account_password + '\'' +
                ", account_email='" + account_email + '\'' +
                '}';
    }
}
