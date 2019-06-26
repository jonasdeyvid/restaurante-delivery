package br.com.restaurante.model;

import java.util.List;

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

	@ManyToMany( targetEntity = Prato.class )
	@ElementCollection
	@JoinTable(name = "carrinho_itens", joinColumns = @JoinColumn(name = "carrinho_codigo", referencedColumnName = "codigo"), inverseJoinColumns = @JoinColumn(name = "item_codigo", referencedColumnName = "codigo"))
	private List<ItemDeCompraAbstrato> itensDeCompra;

	public Long getId() {
		return codigo;
	}

	public void setId(Long id) {
		this.codigo = id;
	}

	public List<ItemDeCompraAbstrato> getItensDeCompra() {
		return itensDeCompra;
	}

	public void setItensDeCompra(List<ItemDeCompraAbstrato> itensDeCompra) {
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

}
