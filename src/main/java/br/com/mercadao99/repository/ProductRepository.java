package br.com.mercadao99.repository;

import br.com.mercadao99.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Long> {

//    List<Product> findByNome(String nome);
//    List<Product> findByPreco(BigDecimal preco);
}

