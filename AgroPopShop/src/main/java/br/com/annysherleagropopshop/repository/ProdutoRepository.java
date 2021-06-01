package br.com.annysherleagropopshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.annysherleagropopshop.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}