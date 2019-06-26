package br.com.restaurante.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Prato extends ItemDeCompraAbstrato{

	@NotBlank(message = "Preencha a campo nome do prato")
	private String nome;
	private String descricao;
	private String ingredientes;
	@NotBlank(message="Preencha o campo preço")
	private double preco;
	private String caminhoImagem;
	
	public Prato() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getPreco() {
		// TODO Auto-generated method stub
		return 0;
	}

}
