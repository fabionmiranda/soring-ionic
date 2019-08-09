/*I - Como criar ENTIDADES - Model 
 * 1-Criar atributo basicos
 * 2-Fazer as associações (inicie as coleções) 
 * 		Relacionamentos: 1 estado pode ter N cidades - terá uma lista de cidades e Cada cidade tem 1 Estado.
 * 3-Criar os construtores (não inclua coleções no construtor com parametros)
 * 4-Criar os Getters e Setters
 * 5-Criar os hashCodes e equals (padrao - somente id)
 * 6-Criar Serializable (1L).
 * 
 * II - Criar MAPEAMENTOS e Associações ORM.
 * 
 */


package com.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class Estado implements Serializable {

	//6
	private static final long serialVersionUID = 1L;
	//1
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	
	// 1 Estado para N Cidades. mapped - do outro lado.
	
	@JsonIgnore
	@OneToMany(mappedBy="estado")	
	private List <Cidade> cidades = new ArrayList<>();
	
	//3 - construtor padrao
	public Estado () {
		
	}
	//3 - construtor automatico.

	public Estado(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	//4
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

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

	//5
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
		Estado other = (Estado) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
	

	

}
