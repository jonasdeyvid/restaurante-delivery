package br.com.restaurante.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.restaurante.model.Carrinho;
import br.com.restaurante.model.Cliente;
import br.com.restaurante.model.ItemDeCompra;
import br.com.restaurante.model.Prato;
import br.com.restaurante.repository.CarrinhoRepository;

@Service
public class CarrinhoService {

	@Autowired
	private CarrinhoRepository carrinhoRepository;
	
	public CarrinhoService() {
		// TODO Auto-generated constructor stub
	}
	
	public Optional<Carrinho> getCarrinhoPorId(Long id) {
		return carrinhoRepository.findById(id);
	}
	
	public void salvar(Carrinho carrinho) {
		carrinhoRepository.save(carrinho);
	}

	
	
	
}
