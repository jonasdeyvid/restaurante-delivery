package br.com.restaurante.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.remoting.httpinvoker.HttpInvokerClientInterceptor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.restaurante.model.Carrinho;
import br.com.restaurante.model.Cliente;
import br.com.restaurante.model.Role;
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
		Cliente cliente = new Cliente();
		mv.addObject(cliente);
		return mv;
	}
	
	@PostMapping("/salvar")
	public ModelAndView salvar(@Validated Cliente cliente, BindingResult result) {
		ModelAndView mv = new ModelAndView("SucessoCadastro");
		ModelAndView mv2 = new ModelAndView("ErroCadastro");
		if(result.hasErrors()) {
			return mv2;
		}
		
		List<Role> roles = new ArrayList<Role>();
		roles.add(new Role("ROLE_USER"));
		cliente.setRoles(roles);
		System.out.println(cliente.getRoles().get(0).getPapel());
		Carrinho carrinho = new Carrinho();
		cliente.setCarrinho(carrinho);
		
		clienteService.salvar(cliente);
		mv.addObject("mensagem", "Pessoa Cadastrada com sucesso");
		
		return mv;
	}
	
	@RequestMapping("/logar")
	public ModelAndView logar(Cliente cliente, HttpSession session) {
		ModelAndView mv = new ModelAndView("Inicio");
		
		if(clienteService.buscarClientePorEmail(cliente.getEmail()) != null) {
			cliente = clienteService.buscarClientePorEmail(cliente.getEmail());
			session.setAttribute("usuarioLogado", cliente);
			return mv;
		}
		
		return mv;
	}
	


}
