package br.com.restaurante.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import br.com.restaurante.model.Pessoa;
import br.com.restaurante.service.PessoaService;

@Controller
@RequestMapping("/pessoa")
public class PessoaController {
	
	@Autowired
	private PessoaService pessoaService;
	
	
	@RequestMapping("/administrador")
	public ModelAndView formAdm() {
		ModelAndView mv = new ModelAndView("administracao");
		return mv;
	}
	
	
	@RequestMapping("/inicio")
	public ModelAndView formIni() {
		ModelAndView mv = new ModelAndView("OlaMundo");
		return mv;
	}
	
	
	@RequestMapping("/formulario")
	public ModelAndView form() {
		ModelAndView mv = new ModelAndView("Formulario");
		mv.addObject(new Pessoa());
		return mv;
	}
	
	
	@PostMapping("/salvar")
	public ModelAndView cadastrar(@Validated Pessoa pessoa, BindingResult result, @RequestParam(value="imagem") MultipartFile imagem) {
		ModelAndView mv = new ModelAndView("Formulario");
		
		if(result.hasErrors()) {
			return mv; //retorna pra página de form e nem tenta salvar
		}
		
		pessoaService.cadastrar(pessoa,imagem);
		mv.addObject("mensagem", "Pessoa Cadastrada com sucesso");
		
		return mv;
	}
	
	@GetMapping("/listar")
	public ModelAndView listarPessoas() {
		List<Pessoa> pessoas = pessoaService.retonarTodasAsPessoas();
		ModelAndView mv = new ModelAndView("PaginaListagem");
		mv.addObject("listaDePessoas", pessoas);
	
		return mv;
	}
	
    @RequestMapping("/excluir/{codigo}")
    public ModelAndView excluirPessoa(@PathVariable Long codigo) {
    	pessoaService.excluirPessoa(codigo);
    	ModelAndView mv = new ModelAndView("redirect:/pessoa/listar");
    	return mv;
    }
	
    @RequestMapping("/atualizar/{codigo}")
    public ModelAndView atualizarPessoa(@PathVariable Long codigo) {
    	Pessoa pessoa = pessoaService.buscarPorId(codigo);
    	ModelAndView mv = new ModelAndView("Formulario");
    	mv.addObject("pessoa", pessoa);
    	return mv;
    	
    }
    
    
    @RequestMapping("/logar")
    public ModelAndView formLogin() {
    	ModelAndView mv = new ModelAndView("Login");
    	return mv;
    }
	
	
}
