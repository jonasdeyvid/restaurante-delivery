package br.com.restaurante.model;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

@Entity
public class Pedido {
//mesmo que venda
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long codigo;
	
	@OneToMany
	@ElementCollection
	@JoinTable( 
	        name = "pedido_itens", 
	        joinColumns = @JoinColumn(
	          name = "pedido_codigo", referencedColumnName = "codigo"), 
	        inverseJoinColumns = @JoinColumn(
	          name = "item_codigo", referencedColumnName = "codigo")) 
	private List<ItemDeCompra> itensDeCompra;
	
	private double precoTotal;
	
	@ManyToOne
	private Cliente comprador;
	public Pedido() {
		// TODO Auto-generated constructor stub
	}
	
	public Pedido(Cliente cliente) {
	}
	
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
	public double getPrecoTotal() {
		return precoTotal;
	}
	public void setPrecoTotal(double precoTotal) {
		this.precoTotal = precoTotal;
	}
	public Cliente getComprador() {
		return this.comprador;
	}
	public void setComprador(Cliente comprador) {
		this.comprador = comprador;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

}
