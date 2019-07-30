package com.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;




// Serializable - dados pode ser convertidos em bytes, gravados em arquivos, trafego em rede.
// 1L = versao 1 . 
//@Entity, @Id... é JPA para mapeamento objeto relacional

@Entity
public class Categoria implements Serializable {

	private static final long serialVersionUID = 1L;
	
	//GenerationType - tipo de geracao de chave primaria.
	@Id	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	
	//RELACIONAMENTO ENTRE CATEGORIA E PRODUTO. (N CATEGORIA PODE TER M PRODUTOS)
	// N Categoria deve possuir varios N (list ) de produtos
	//produtos - nome do papel da associacao.
	//JsonManagedReference - referencia gerenciada pelo json - jackson.
	
	@ManyToMany(mappedBy="categorias")
	public List<Produtos> produtos =  new ArrayList<>();
	
	
	public List<Produtos> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produtos> produtos) {
		this.produtos = produtos;
	}

	public Categoria() {
		
	}

	public Categoria(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public Integer getId() {
		return id;
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
		Categoria other = (Categoria) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
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
	
	
}
