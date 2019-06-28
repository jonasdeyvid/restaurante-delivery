package br.com.restaurante.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.restaurante.model.Pedido;
import br.com.restaurante.repository.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	public PedidoService() {
		// TODO Auto-generated constructor stub
	}

	public void salvar(Pedido pedido) {
		pedidoRepository.save(pedido);
		
	}

	public Optional<Pedido> buscar(Long id) {
		// TODO Auto-generated method stub
		return pedidoRepository.findById(id);
	}

}
