package br.com.restaurante.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.restaurante.model.Cliente;
import br.com.restaurante.service.ClienteService;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	public ClienteController() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping("/cadastro")
	public ModelAndView cadastro() {
		ModelAndView mv = new ModelAndView("Cadastro");
		mv.addObject(new Cliente());
		return mv;
	}
	
	@PostMapping("/salvar")
	public ModelAndView salvar(@Validated Cliente cliente, BindingResult result) {
		ModelAndView mv = new ModelAndView("Cadastro");
		
		if(result.hasErrors()) {
			return mv;
		}
		
		clienteService.salvar(cliente);
		mv.addObject("mensagem", "Pessoa Cadastrada com sucesso");
		
		return mv;
		
	}

}
