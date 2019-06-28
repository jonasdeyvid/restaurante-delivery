package br.com.restaurante.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.restaurante.model.Carrinho;
import br.com.restaurante.model.Cliente;
import br.com.restaurante.model.ItemDeCompra;
import br.com.restaurante.model.Pedido;
import br.com.restaurante.service.ClienteService;
import br.com.restaurante.service.PedidoService;

@Controller
@RequestMapping("/pedido")
public class PedidoController {

	@Autowired
	private PedidoService pedidoService;
	
	@Autowired
	private ClienteService clienteService;
	
	public PedidoController() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping("/cadastrar")
	public void cadastrar(Pedido pedido) {
		pedidoService.salvar(pedido);
	}
	
	@RequestMapping("/confirmarPedido")
	public ModelAndView confirmarPedido() {
		ModelAndView mv = new ModelAndView("SucessoPedido");
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String nome;
		if (principal instanceof UserDetails) {
			nome = ((UserDetails) principal).getUsername();
		} else {
			nome = principal.toString();
		}

		Cliente cliente = new Cliente();
		cliente = clienteService.buscarClientePorEmail(nome);
		
		if(cliente != null) {
		Carrinho carrinho = cliente.getCarrinho();
		Pedido pedido = new Pedido();
		List<ItemDeCompra> itensCompra = new ArrayList<ItemDeCompra>(cliente.getCarrinho().getItensDeCompra());
		
		pedido.setComprador(cliente);
		pedido.setItensDeCompra(itensCompra);
		pedido.setPrecoTotal(carrinho.getPrecoTotal());
		System.out.println(pedido.getItensDeCompra().size());
		System.out.println(pedido.getItensDeCompra().get(0).getNome());
		System.out.println(pedido.getItensDeCompra().get(1).getNome());
		
		Pedido p2 = new Pedido();
		p2 = pedido;
		cliente.adicionarPedido(p2);
		System.out.println("pedidooooo "+cliente.getPedidos().get(0).getItensDeCompra().get(0).getNome());
		clienteService.salvar(cliente);
		cliente.getCarrinho().esvaziarCarrinho();
		clienteService.salvar(cliente);
		}
		return mv;
	}

	@RequestMapping("/meusPedidos")
	public ModelAndView verPedidos() {
		ModelAndView mv = new ModelAndView("VerPedidos");
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String nome;
		if (principal instanceof UserDetails) {
			nome = ((UserDetails) principal).getUsername();
		} else {
			nome = principal.toString();
		}

		Cliente cliente = new Cliente();
		cliente = clienteService.buscarClientePorEmail(nome);
		
		if(cliente != null) {
			mv.addObject("pedidos", cliente.getPedidos());
		}
		
		return mv;
	}
}
