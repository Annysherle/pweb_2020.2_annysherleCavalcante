package br.com.annysherle.agropopshop.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.annysherle.agropopshop.api.models.Pedido;


@Repository
public interface PedidoRepository  extends JpaRepository<Pedido, Long>{
	
}