package br.com.restaurante.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.restaurante.model.Cliente;
import br.com.restaurante.model.Pessoa;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

	Cliente findByEmail(String email);

}
