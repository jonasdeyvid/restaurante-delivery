package br.com.restaurante.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Carrinho {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long codigo;

	@ManyToMany
	@ElementCollection
	@JoinTable(name = "carrinho_itens", joinColumns = @JoinColumn(name = "carrinho_codigo", referencedColumnName = "codigo"), inverseJoinColumns = @JoinColumn(name = "item_codigo", referencedColumnName = "codigo"))
	private List<ItemDeCompra> itensDeCompra;

	public Long getId() {
		return codigo;
	}

	public void setId(Long id) {
		this.codigo = id;
	}

	public List<ItemDeCompra> getItensDeCompra() {
		return itensDeCompra;
	}

	public void setItensDeCompra(List<ItemDeCompra> itensDeCompra) {
		this.itensDeCompra = itensDeCompra;
	}

	// se o método nao rodar no thymeleaf, criar uma variavel pra isso!!!

	public double getPrecoTotal() {
		double precoTotal = 0;
		for (ItemDeCompra i : itensDeCompra) {
			precoTotal += i.getPreco();
		}

		return precoTotal;
	}

	public Carrinho() {
		// TODO Auto-generated constructor stub
	}
	
	public void removerPrato(Prato item) {
		itensDeCompra.remove(item);
	}
	
	public void esvaziarCarrinho() {
		itensDeCompra = new ArrayList<ItemDeCompra>();
	}
	
//	public void adicionarPrato(Prato prato) {
//		itensDeCompra.add(prato);
//	}

	public void adicionarItem(ItemDeCompra item) {
		this.itensDeCompra.add(item);
	}
	
	public void RemoverPrato(Prato prato2) {
		itensDeCompra.remove(prato2);
		
	}

	public void removerItem(ItemDeCompra itemDeCompra) {
		itensDeCompra.remove(itemDeCompra);
		
	}
	

}
