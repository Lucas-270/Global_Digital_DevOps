package br.com.mercadao99.repository;

import br.com.mercadao99.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Long> {

//    Optional<Cart> findByLoja(String razaoSocial);
//    Optional<Cart> findByUsurio(String email);

}
