package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.models.Categoria;
import com.services.CategoriaService;

@RestController
@RequestMapping (value="/categorias")
public class CategoriaControllerResponse {

	//Injecao dependencia - do Service para o Controller.
	@Autowired
	private CategoriaService categoriaService;
		
	
	//@PathVariable - conectar id do request com o do parametro.
	// ResponseEntity - retorna encapsulado resposta HTTP tipo REST.
	
	@RequestMapping(value="/{id}",  method=RequestMethod.GET)
	public ResponseEntity<?> listar(@PathVariable Integer id) {
			Categoria objeto = categoriaService.buscarPorId(id);
			
	return ResponseEntity.ok(objeto);		
		
	}	
}
	
	

