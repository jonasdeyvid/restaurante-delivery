package br.com.restaurante.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

@Entity
public class ProdutoAbstrato {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long codigo;


	
	
	@NotBlank(message = "Preencha a campo nome do item")
	private String nome;
	private String descricao;
	private String ingredientes;
//	@NotBlank(message="Preencha o campo preço")
	private double preco;
	private String caminhoImagem;
	
	@OneToMany(mappedBy = "prato")
	private List<ItemDeCompra> itensDeCompra;
	
	
	
	public ProdutoAbstrato(Long codigo) {
		this.setCodigo(codigo);
	}
	
	public ProdutoAbstrato() {
	}
	
	

	public List<ItemDeCompra> getItensDeCompra() {
		return itensDeCompra;
	}



	public void setItensDeCompra(List<ItemDeCompra> itensDeCompra) {
		this.itensDeCompra = itensDeCompra;
	}



	public double getPreco() {
		// TODO Auto-generated method stub
		return preco;
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

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
}
