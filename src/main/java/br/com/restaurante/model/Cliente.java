package br.com.restaurante.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Cliente extends Pessoa {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Cliente() {
		// TODO Auto-generated constructor stub
	}
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name="Cliente_Carrinho",
              joinColumns={@JoinColumn(name="cliente_codigo",  
               referencedColumnName="codigo")},  
              inverseJoinColumns={@JoinColumn(name="carrinho_codigo",   
               referencedColumnName="codigo")})  
	private Carrinho carrinho;

	
//	@JoinTable( 
//	        name = "pessoas_pedidos", 
//	        joinColumns = @JoinColumn(
//	          name = "pessoa_codigo", referencedColumnName = "codigo"), 
//	        inverseJoinColumns = @JoinColumn(
//	          name = "pedido_codigo", referencedColumnName = "codigo")) 
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<Pedido> pedidos;
	
	public Carrinho getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(Carrinho carrinho) {
		this.carrinho = carrinho;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public void adicionarPedido(Pedido pedido) {
		this.pedidos.add(pedido);
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

}
