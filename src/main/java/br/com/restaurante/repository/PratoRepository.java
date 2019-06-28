package br.com.restaurante.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.restaurante.model.Prato;

@Repository
public interface PratoRepository extends JpaRepository<Prato, Long>{

	Prato findByCodigo(Long codigo);

}
