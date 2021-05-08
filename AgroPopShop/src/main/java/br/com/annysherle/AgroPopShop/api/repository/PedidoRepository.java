package br.com.annysherle.AgroPopShop.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.annysherle.AgroPopShop.api.models.Pedido;


@Repository
public interface PedidoRepository  extends JpaRepository<Pedido, Long>{
	
}