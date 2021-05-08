package br.com.annysherle.AgroPopShop.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.annysherle.AgroPopShop.api.models.Produto;

@Repository
public interface ProdutoRepository  extends JpaRepository<Produto, Long>{

}
