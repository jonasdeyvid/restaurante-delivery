package br.com.restaurante.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class ItemDeCompra {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long codigo;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
//	@NotBlank(message = "Preencha a campo nome do item")
	private String nome;
	private String descricao;
	private String ingredientes;
//	@NotBlank(message="Preencha o campo preço")
	private double preco;
	private String caminhoImagem;
	
	@ManyToOne	
	private Prato prato; 
	
	@ManyToOne
	private Pedido pedido;
	
	
	
	public ItemDeCompra() {
		//
	}

	public ItemDeCompra(Prato prato) {
		this.caminhoImagem = prato.getCaminhoImagem();
		this.descricao = prato.getDescricao();
		this.ingredientes = prato.getIngredientes();
		this.nome = prato.getNome();
		this.prato = prato;
		this.preco = prato.getPreco();
	}

	
	public double getPreco() {
		// TODO Auto-generated method stub
		return this.preco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(String ingredientes) {
		this.ingredientes = ingredientes;
	}

	public String getCaminhoImagem() {
		return caminhoImagem;
	}

	public void setCaminhoImagem(String caminhoImagem) {
		this.caminhoImagem = caminhoImagem;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	public void adicionarPratoAItem(Prato prato) {
		this.caminhoImagem = prato.getCaminhoImagem();
		this.descricao = prato.getDescricao();
		this.ingredientes = prato.getIngredientes();
		this.nome = prato.getNome();
		this.prato = prato;
		this.preco = prato.getPreco();
	}

	public Prato getPrato() {
		return prato;
	}

	public void setPrato(Prato prato) {
		this.prato = prato;
	}

}
