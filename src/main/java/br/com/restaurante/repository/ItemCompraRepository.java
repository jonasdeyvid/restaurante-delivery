package br.com.restaurante.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.restaurante.model.ItemDeCompra;

@Repository
public interface ItemCompraRepository extends JpaRepository<ItemDeCompra, Long>{

}
