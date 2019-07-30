package com.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.models.Categoria;
import com.repository.CategoriaRepository;

import javassist.NotFoundException;

@Service
public class CategoriaService {
	
	//metodo para buscar no repository as acoes do Crud por meio 
	//de DI - Injeção dependencia / Inversão de Controle - categoriaRepository - @Autowired
	
	@Autowired
	private CategoriaRepository categoriaRepository;	
	
	//buscar categoria por id
	public Categoria buscarPorId(Integer id) throws Exception   {
		Categoria objeto = categoriaRepository.findOne(id); // se o id não existe ele retorna null.	
		//tratamento objeto = null então há excessao
		if (objeto == null) {
			throw new NotFoundException("Objeto não encontrado Id :" + id + "Tipo" + Categoria.class.getName());
		}
	return objeto;
		
	}
	
	public Categoria inserirCategorias (Categoria obj) {
		obj.setId(null); // define como nulo para inserir
		return categoriaRepository.save(obj);
	}
	
	public Categoria atualizarCategorias (Categoria obj) {
		return categoriaRepository.save(obj);
	}
	

}
