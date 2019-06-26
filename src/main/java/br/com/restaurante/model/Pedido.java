package br.com.restaurante.model;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

@Entity
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long codigo;
	
	@NotBlank
	@OneToMany
	@ElementCollection
	@JoinTable( 
	        name = "pedido_itens", 
	        joinColumns = @JoinColumn(
	          name = "pedido_codigo", referencedColumnName = "codigo"), 
	        inverseJoinColumns = @JoinColumn(
	          name = "item_codigo", referencedColumnName = "codigo")) 
	private List<ItemDeCompraAbstrato> itensDeCompra;
	private double precoTotal;
	private Long idComprador;
	public Pedido() {
		// TODO Auto-generated constructor stub
	}
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
	public double getPrecoTotal() {
		return precoTotal;
	}
	public void setPrecoTotal(double precoTotal) {
		this.precoTotal = precoTotal;
	}
	public Long getIdComprador() {
		return idComprador;
	}
	public void setIdComprador(Long idComprador) {
		this.idComprador = idComprador;
	}

}
