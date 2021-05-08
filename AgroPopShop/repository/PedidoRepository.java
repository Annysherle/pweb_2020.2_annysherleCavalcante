package br.com.annysherle.agropopshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.annysherle.agropopshop.models.Pedido;


@Repository
public interface PedidoRepository  extends JpaRepository<Pedido, Long>{
	
}