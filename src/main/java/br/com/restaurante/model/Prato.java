package br.com.restaurante.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

@Entity
public class Prato extends ProdutoAbstrato{
	public Prato() {
		
	}
	
	public Prato(Long id) {
		super(id);
	}

}
