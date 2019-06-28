package br.com.restaurante.controller;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.restaurante.model.Carrinho;
import br.com.restaurante.model.Cliente;
import br.com.restaurante.model.Pedido;
import br.com.restaurante.model.Prato;

@Controller
@RequestMapping("/restaurante")
public class RestauranteController {
	
	@Autowired
	private PedidoController pedidoController;
	
	@Autowired
	private PratoController pratoController;
	
	public RestauranteController() {
		// TODO Auto-generated constructor stub
	}

	@RequestMapping("/")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView("Inicio");
		return mv;
	}
	
//	@RequestMapping("/realizarPedido/{cliente}")
//	public ModelAndView fazerPedido(@PathVariable Cliente cliente) {
//		ModelAndView mv = new ModelAndView("SucessoPedido");
//		realizarPedido(cliente);
//		return mv;
//	}
	
//	@RequestMapping("/carrinho")
//	public ModelAndView carrinho() {
//		ModelAndView mv = new ModelAndView("Carrinho");
//		
//		Cliente cliente = 
//		mv.addObject("itens",cliente.getCarrinho().getItensDeCompra());
//	}
//	
	
//	public boolean realizarPedido(Cliente cliente) {
//		if(cliente != null && !cliente.getCarrinho().equals(null) && cliente.getCarrinho().getItensDeCompra().size() > 0) {
//			Pedido pedido = new Pedido(cliente.getCarrinho(), cliente);
//			
//			pedidoController.cadastrar(pedido);
//			
//			return true;
//		}
//		
//		return false;
//	}
	
	@RequestMapping("/verPratos")
	public ModelAndView verPratos() {
		ModelAndView mv = new ModelAndView("VerPratos");
		List<Prato> pratos = pratoController.getPratos();
		Cliente cliente = new Cliente();
		mv.addObject("pratos", pratos);
		mv.addObject(cliente);
		return mv;
	}
	
	@RequestMapping("/logar")
	public ModelAndView logar() {
		ModelAndView mv = new ModelAndView("Login");
		Cliente c = new Cliente();
		mv.addObject(c);
		return mv;
	}
}
