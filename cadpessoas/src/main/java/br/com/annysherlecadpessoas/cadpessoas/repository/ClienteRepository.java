package br.com.annysherlecadpessoas.cadpessoas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.annysherlecadpessoas.cadpessoas.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
