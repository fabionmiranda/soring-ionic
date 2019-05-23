package com.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.models.Categoria;
import com.repository.CategoriaRepository;

@Service
public class CategoriaService {
	
	//metodo para buscar no repository as acoes do Crud por meio 
	//de DI - Injeção dependencia / Inversão de Controle - categoriaRepository - @Autowired
	
	@Autowired
	private CategoriaRepository categoriaRepository;	
	
	//buscar categoria por id
	public Categoria buscarPorId(Integer id) {
		Categoria objeto = categoriaRepository.findOne(id);		
	
	return objeto;
		
	}

}
