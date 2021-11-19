package br.com.mercadao99.model;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class Login {

    @NotBlank @Email
    private String email;

    @NotBlank
    private String senha;

    public UsernamePasswordAuthenticationToken getAuthentication(){
        return new UsernamePasswordAuthenticationToken(email, senha);
    }

}
