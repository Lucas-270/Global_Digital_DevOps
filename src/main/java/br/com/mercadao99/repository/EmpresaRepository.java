package br.com.mercadao99.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mercadao99.model.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long>{

}
