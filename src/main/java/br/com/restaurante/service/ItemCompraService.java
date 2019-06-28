package br.com.restaurante.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.restaurante.model.ItemDeCompra;
import br.com.restaurante.repository.ItemCompraRepository;

@Service
public class ItemCompraService {
	@Autowired
	private ItemCompraRepository itemCompraRepository;

	public void salvar(ItemDeCompra item) {
		itemCompraRepository.save(item);
	}
	
	public void remover(ItemDeCompra item) {
		itemCompraRepository.delete(item);
	}

	public Optional<ItemDeCompra> buscar(Long codigo) {
		return itemCompraRepository.findById(codigo);
	}
}
