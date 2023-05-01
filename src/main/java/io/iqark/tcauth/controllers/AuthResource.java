package io.iqark.tcauth.controllers;

import io.iqark.tcauth.pojo.AccountCreateRq;
import io.iqark.tcauth.pojo.AccountVerifyRq;
import io.iqark.tcauth.service.AuthService;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/auth")
public class AuthResource {
    @Inject
    AuthService authService;

    @GET
    @Path("/getAccount/{userName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAccount(@PathParam(value = "userName") String userName) {
        return authService.getAccount(userName);
    }

    @POST
    @Path("/verifyAccount")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response verifyAccount(@Valid AccountVerifyRq accountVerifyRq) {
        return authService.verifyAccount(accountVerifyRq);
    }

    @POST
    @Path("/createAccount")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createAccount(@Valid AccountCreateRq accountCreateRq) {
        return authService.createAccount(accountCreateRq);
    }
}