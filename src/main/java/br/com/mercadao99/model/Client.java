package br.com.mercadao99.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import java.util.Collection;

@Entity
public class Client extends User{

    public Client(Long id, String nome, String email, String password, Collection<Role> roles) {
        super(id, nome, email, password, roles);
    }
}
