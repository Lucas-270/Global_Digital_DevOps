package br.com.mercadao99.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mercadao99.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
