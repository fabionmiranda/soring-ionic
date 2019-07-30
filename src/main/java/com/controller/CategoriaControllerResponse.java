package com.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	public ResponseEntity<?> listar(@PathVariable Integer id) throws Exception {
			Categoria objeto = categoriaService.buscarPorId(id);
			
	return ResponseEntity.ok(objeto);		
		
	}
	
	// @RequestBody - json ser convertido para objeto body automaticamente
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Categoria> insert(@Valid @RequestBody Categoria obj) {
		// Categoria obj = categoriaService.fromDTO(objDto);
		obj = categoriaService.inserirCategorias(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	

	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody Categoria obj, @PathVariable Integer id) {

		obj = categoriaService.atualizarCategorias(obj);
		obj.setId(id);
		
		return ResponseEntity.noContent().build();
	}
	
	
}
	
	

