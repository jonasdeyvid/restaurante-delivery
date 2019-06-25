package br.com.restaurante.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.restaurante.repository.CarrinhoRepository;

@Service
public class CarrinhoService {

	@Autowired
	private CarrinhoRepository carrinhoRepository;
	
	public CarrinhoService() {
		// TODO Auto-generated constructor stub
	}

}
