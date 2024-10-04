package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
//"hasAnyAuthority('READ_PRIVILEGES', 'WRITE_PRIVILEGES', 'DELETE_PRIVILEGES')")
@RestController
public class TestRolesController {


    @GetMapping("/accessAdmin")
    @PreAuthorize("hasRole('ADMIN')")
    public String accessAdmin(){

        return "hola, has accedido con rol de admin";
    }
    @GetMapping("/accesUser")
    @PreAuthorize("hasRole('USER')")//hasAnyRole
    public String accessUser(){

        return "hola, has accedido con rol de User";
    }
    @GetMapping("/accesInvited")
    @PreAuthorize("hasRole('INVITED')")
    public String accessInvited(){

        return "hola, has accedido con rol de Invited";
    }



}
