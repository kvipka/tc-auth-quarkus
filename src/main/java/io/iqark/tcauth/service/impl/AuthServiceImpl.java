package io.iqark.tcauth.service.impl;

import io.iqark.tcauth.entity.Account;
import io.iqark.tcauth.pojo.AccountCreateRq;
import io.iqark.tcauth.pojo.AccountVerifyRq;
import io.iqark.tcauth.pojo.CustomResponse;
import io.iqark.tcauth.service.AuthService;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;

import static io.iqark.tcauth.utils.Utils.*;

@ApplicationScoped
public class AuthServiceImpl implements AuthService {
    @Override
    public Response getAccount(String userName) {
        Account account = Account.findByUsername(userName.toUpperCase());
        if (account == null) {
            return Response.status(Response.Status.OK)
                    .entity(new CustomResponse("getAccount", String.format("Account %s does not exist", userName)))
                    .build();
        }
        return Response.status(Response.Status.OK)
                .entity(account)
                .build();
    }

    @Override
    public Response verifyAccount(AccountVerifyRq accountVerifyRq) {
        Account account = Account.findByUsername(accountVerifyRq.getAccount_name().toUpperCase());
        if (account == null) {
            return Response.status(Response.Status.OK)
                    .entity(new CustomResponse("verifyAccount", String.format("Account %s does not exist", accountVerifyRq.getAccount_name())))
                    .build();
        }

        if (!verifySRP6(accountVerifyRq.getAccount_name(), accountVerifyRq.getAccount_password(), account.getSalt(), account.getVerifier())) {
            return Response.status(Response.Status.OK)
                    .entity(new CustomResponse("verifyAccount", "Login or Password incorrect"))
                    .build();
        }

        return Response.status(Response.Status.OK)
                .entity(new CustomResponse())
                .build();
    }

    @Override
    public Response createAccount(AccountCreateRq accountCreateRq) {
        Account account = Account.findByUsername(accountCreateRq.getAccount_name().toUpperCase());
        if (account != null) {
            return Response.status(Response.Status.OK)
                    .entity(new CustomResponse("createAccount", String.format("Account %s already exist", accountCreateRq.getAccount_name())))
                    .build();
        }

        addAccount(accountCreateRq);
        return Response.status(Response.Status.OK)
                .entity(new CustomResponse())
                .build();
    }

    @Transactional(value = Transactional.TxType.REQUIRES_NEW, rollbackOn = Exception.class)
    protected void addAccount(AccountCreateRq accountCreateRq) {
        // Reg
        byte[] salt = generateRandomSalt(32);
        byte[] verifier = calculateSRP6TCVerifier(accountCreateRq.getAccount_name(), accountCreateRq.getAccount_password(), salt);

        Account account = new Account();
        account.setUsername(accountCreateRq.getAccount_name().toUpperCase());
        account.setSalt(salt);
        account.setVerifier(verifier);
        account.setEmail(accountCreateRq.getAccount_email());
        account.setRegMail(accountCreateRq.getAccount_email());
        account.setLastIp("127.0.0.1");
        account.setLastAttemptIp("127.0.0.1");
        account.setFailedLogins(0);
        account.setLocked(0);
        account.setLockCountry("00");
        account.setOnline(0);
        account.setExpansion(2);
        account.setMuteTime(0L);
        account.setMuteReason("");
        account.setMuteBy("");
        account.setLocale(0);
        account.setOs("");
        account.setRecruiter(0);
        account.persist();
    }
}
