package br.com.annysherleagropopshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.annysherleagropopshop.model.Cliente;


public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
