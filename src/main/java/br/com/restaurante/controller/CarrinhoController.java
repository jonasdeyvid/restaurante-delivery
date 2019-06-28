package br.com.restaurante.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.restaurante.model.Carrinho;
import br.com.restaurante.model.Cliente;
import br.com.restaurante.model.ItemDeCompra;
import br.com.restaurante.model.Prato;
import br.com.restaurante.service.CarrinhoService;
import br.com.restaurante.service.ClienteService;
import br.com.restaurante.service.ItemCompraService;
import br.com.restaurante.service.PratoService;
import br.com.restaurante.util.PratoItemUtil;

@Controller
@RequestMapping("/carrinho")
public class CarrinhoController {

	@Autowired
	private CarrinhoService carrinhoService;

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private PratoService pratoService;
	
	@Autowired
	private ItemCompraService itemCompraService;

	public CarrinhoController() {
		// TODO Auto-generated constructor stub
	}

	@RequestMapping("/listar")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("Carrinho");

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

		mv.addObject(carrinho);
		mv.addObject("listaItens", carrinho.getItensDeCompra());
		double total = cliente.getCarrinho().getPrecoTotal();
		String Ptotal = String.valueOf(total);
		mv.addObject("precoTotal", Ptotal);
		}
		return mv;
	}

	@RequestMapping("/adicionar/{codigo}")
	public ModelAndView adicionarPrato(@PathVariable Long codigo) {
		ModelAndView mv = new ModelAndView("redirect:/restaurante/verPratos");

//		Object auth = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		if(!auth.equals(null)) {
//		UserDetails user = (UserDetails) auth;
//		Cliente cliente = clienteService.buscarClientePorEmail(user.getUsername());
//		Carrinho carrinho = cliente.getCarrinho();
//		
//		carrinho.getItensDeCompra().add(prato);
//		carrinhoService.salvar(carrinho);
//		}

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

		Prato prato2;
		prato2 = pratoService.buscarPorId(codigo);

		ItemDeCompra item = PratoItemUtil.transformaPratoEmItem(prato2);
		
		
		carrinho.adicionarItem(item);
		itemCompraService.salvar(item);
		carrinhoService.salvar(carrinho);
		
		cliente.setCarrinho(carrinho);
		clienteService.salvar(cliente);
		}
		return mv;
	}

	@RequestMapping("/remover/{codigo}")
	public ModelAndView removerPrato(@PathVariable Long codigo) {
		ModelAndView mv = new ModelAndView("redirect:/carrinho/listar");

		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String nome;
		if (principal instanceof UserDetails) {
			nome = ((UserDetails) principal).getUsername();
		} else {
			nome = principal.toString();
		}

		Cliente cliente = new Cliente();
		cliente = clienteService.buscarClientePorEmail(nome);

		Carrinho carrinho = cliente.getCarrinho();

//		Prato prato2 = new Prato(codigo);
//		prato2 = pratoService.buscarPorId(codigo);
		
		Optional<ItemDeCompra> item = itemCompraService.buscar(codigo);
		
		System.out.println(item.get().getNome());
		carrinho.removerItem(item.get());

		carrinhoService.salvar(carrinho);
		cliente.setCarrinho(carrinho);
		clienteService.salvar(cliente);
		
		return mv;
	}
}
