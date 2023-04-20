package com.restapicode.controllers;

import com.restapicode.pojo.AccountCreateRq;
import com.restapicode.pojo.AccountVerifyRq;
import com.restapicode.service.AuthService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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