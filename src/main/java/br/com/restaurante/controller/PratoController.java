package br.com.restaurante.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import br.com.restaurante.model.Pessoa;
import br.com.restaurante.model.Prato;
import br.com.restaurante.service.PratoService;

@Controller
@RequestMapping("/prato")
public class PratoController {

	@Autowired
	private PratoService pratoService;
	
	public PratoController() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping("/cadastrar")
	public ModelAndView cadastrarPrato() {
		ModelAndView mv = new ModelAndView("CadastrarPrato");
		mv.addObject(new Prato());
		return mv;
	}
	
	@RequestMapping("/salvar")
	public ModelAndView salvarPrato(@Validated Prato prato, BindingResult result, @RequestParam(value="imagem") MultipartFile imagem) {
		ModelAndView mv = new ModelAndView("CadastrarPrato");
		
		if(result.hasErrors()) {
			return mv; //retorna pra página de form e nem tenta salvar
		}
		
		pratoService.cadastrar(prato,imagem);
		mv.addObject("mensagem", "Pessoa Cadastrada com sucesso");
		return mv;
	}
	
	@RequestMapping("/listar")
	public ModelAndView listarPratos() {
		List<Prato> pratos = pratoService.getAllPratos();
		ModelAndView mv = new ModelAndView("ListagemPratos");
		mv.addObject("listaDePratos",pratos);
		return mv;
		
	}
	
	@RequestMapping("/excluir/{codigo}")
    public ModelAndView excluirPessoa(@PathVariable Long codigo) {
    	pratoService.excluirPrato(codigo);
    	ModelAndView mv = new ModelAndView("redirect:/prato/listar");
    	return mv;
    }
	
    @RequestMapping("/atualizar/{codigo}")
    public ModelAndView atualizarPessoa(@PathVariable Long codigo) {
    	Prato prato = pratoService.buscarPorId(codigo);
    	ModelAndView mv = new ModelAndView("Formulario");
    	mv.addObject("prato", prato);
    	return mv;
    	
    }
    
    public List<Prato> getPratos(){
    	return pratoService.getAllPratos();
    }

}
