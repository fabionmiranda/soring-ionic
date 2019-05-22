package com.models;

import java.util.ArrayList;
import java.util.List;

public class ProdutoAntigo {

	private Integer id;
	private String nome;
	private Double preco;
	
	//um produto tem varias categorias	
	private List<Categoria> categoria = new ArrayList<>();

	public ProdutoAntigo () {
		
	}
	public ProdutoAntigo(Integer id, String nome, Double preco) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
	}
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
	public List<Categoria> getCategoria() {
		return categoria;
	}
	public void setCategoria(List<Categoria> categoria) {
		this.categoria = categoria;
	}
	
	
}
