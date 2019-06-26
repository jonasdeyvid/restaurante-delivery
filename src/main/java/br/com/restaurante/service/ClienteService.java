package br.com.restaurante.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.restaurante.model.Cliente;
import br.com.restaurante.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public ClienteService() {
		// TODO Auto-generated constructor stub
	}

	public void salvar(Cliente cliente) {
		cliente.setSenha(new BCryptPasswordEncoder().encode(cliente.getSenha()));
		
		clienteRepository.save(cliente);
	}
	
}
