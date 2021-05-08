package br.com.annysherle.agropopshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.annysherle.agropopshop.models.Cliente;

@Repository
public interface ClienteRepository  extends JpaRepository<Cliente, Long>{
	
}
