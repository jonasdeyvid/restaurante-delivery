package br.com.restaurante.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.restaurante.repository.PratoRepository;

@Service
public class PratoService {

	@Autowired
	private PratoRepository pratoRepository;
	
	public PratoService() {
		// TODO Auto-generated constructor stub
	}

}
