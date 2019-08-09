package com.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Produtos implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private Double preco;
	
	//RELACIONAMENTO ENTRE PRODUTO E CATEGORIA. (N PRODUTOS estao associados M CATEGORIA)
	// categorias- nome do papel da associacao.
	//@ManyToMany e JoinTable - definir a "TERCEIRA" tabela (PRODUTO_CATEGORIA) para fazer o join table.
	//JoinColunm - nome da chave estrangeira.
	//JoinTable - criar 3a. tabela com join.
	//@JsonBackReference - omite a lista de produtos.
	
	@JsonIgnore
	@ManyToMany()
	@JoinTable(name="PRODUTO_CATEGORIA",
		joinColumns = @JoinColumn(name="produtos_id"), //chave estrang. do produto.
		inverseJoinColumns = @JoinColumn(name="categoria_id") // chave estrang. categ.
	)		
	public List<Categoria> categorias =  new ArrayList<>();
	
	// classe Pedido precisa conhecer os ItemPedido = itens = itens de pedido.
	private Set<ItemPedido> itens = new HashSet<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public Produtos ( ) {
		
	}
	public Produtos(Integer id, String nome, Double preco) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produtos other = (Produtos) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
