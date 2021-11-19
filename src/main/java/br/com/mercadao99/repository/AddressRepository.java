package br.com.mercadao99.repository;


import br.com.mercadao99.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
