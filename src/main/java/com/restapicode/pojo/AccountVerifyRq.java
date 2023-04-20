package com.restapicode.pojo;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.validation.constraints.NotNull;

public class AccountVerifyRq {
    @Schema(required = true, description = "Account username")
    @NotNull(message = "account_name does not exist")
    private String account_name;
    @Schema(required = true, description = "Account password")
    @NotNull(message = "account_password does not exist")
    private String account_password;

    public String getAccount_name() {
        return account_name;
    }

    public String getAccount_password() {
        return account_password;
    }

    @Override
    public String toString() {
        return "AccountVerifyRq{" +
                "account_name='" + account_name + '\'' +
                ", account_password='" + account_password + '\'' +
                '}';
    }
}
