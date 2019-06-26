package br.com.restaurante.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.restaurante.model.Pessoa;
import br.com.restaurante.repository.PessoaRepository;
import br.com.restaurante.util.AulaFileUtils;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public void cadastrar(Pessoa pessoa, MultipartFile imagem) {
		
		pessoa.setSenha(new BCryptPasswordEncoder().encode(pessoa.getSenha()));
		
		
		//String caminho = "images/" + pessoa.getNome() + ".png";
		
		//AulaFileUtils.salvarImagem(caminho,imagem);
		
		pessoaRepository.save(pessoa);
	}
	
	
	public List<Pessoa> retonarTodasAsPessoas(){
		return pessoaRepository.findAll();
	}


	public void excluirPessoa(Long codigo) {
		pessoaRepository.deleteById(codigo);
		
	}


	public Pessoa buscarPorId(Long codigo) {
		return pessoaRepository.getOne(codigo);
	}
	
	
	
	

}
