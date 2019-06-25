package br.com.restaurante.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.restaurante.model.Pessoa;

@Repository
public interface CarrinhoRepository extends JpaRepository<Pessoa, Long>{

}
