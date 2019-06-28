package br.com.restaurante.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.restaurante.model.Prato;
import br.com.restaurante.repository.PratoRepository;
import br.com.restaurante.util.AulaFileUtils;

@Service
public class PratoService {

	@Autowired
	private PratoRepository pratoRepository;
	
	public PratoService() {
		// TODO Auto-generated constructor stub
	}

	public void cadastrar(Prato prato, MultipartFile imagem) {
		
		Prato p = pratoRepository.save(prato);
		
		prato.setCaminhoImagem("images/"+p.getNome()+p.getCodigo()+".png");
		System.out.println(prato.getCaminhoImagem());
		AulaFileUtils.salvarImagem(prato.getCaminhoImagem(), imagem);
	}

	public List<Prato> getAllPratos() {
		return pratoRepository.findAll();
	}

	public void excluirPrato(Long codigo) {
		pratoRepository.deleteById(codigo);
		
	}

	public Prato buscarPorId(Long codigo) {
		return pratoRepository.findByCodigo(codigo);
	}

}
