package br.com.mercadao99.repository;

import br.com.mercadao99.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StoreRepository extends JpaRepository<Store, Long>{

//    Optional<Store> findByRazaoSocial(String razaoSocial);
//    List<Store> findByCidade(String cidade);
//    List<Store> findByCidadeEBairro(String cidade, String bairro);
 }
