package com.restapicode.service;

import com.restapicode.pojo.AccountCreateRq;
import com.restapicode.pojo.AccountVerifyRq;

import javax.ws.rs.core.Response;

public interface AuthService {
    Response getAccount(String userName);
    Response verifyAccount(AccountVerifyRq accountCreateRq);
    Response createAccount(AccountCreateRq accountCreateRq);
}
