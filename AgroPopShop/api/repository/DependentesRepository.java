package br.com.annysherle.agropopshop.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.annysherle.agropopshop.api.models.Dependentes;

@Repository
public interface DependentesRepository extends JpaRepository<Dependentes, Long>{

}
