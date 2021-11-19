package br.com.mercadao99.model;

import javax.persistence.Entity;
import java.util.Collection;

@Entity
public class Store extends User {

    public Store(Long id, String nome, String email, String password, Collection<Role> roles) {
        super(id, nome, email, password, roles);
    }
}
