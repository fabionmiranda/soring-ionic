package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.models.Cliente;
import com.services.ClienteService;

@RestController
@RequestMapping (value="/clientes")
public class ClienteController {

	//Injecao dependencia - do Service para o Controller.
	@Autowired
	private ClienteService categoriaService;
		
	
	//@PathVariable - conectar id do request com o do parametro.
	// ResponseEntity - retorna encapsulado resposta HTTP tipo REST.
	
	@RequestMapping(value="/{id}",  method=RequestMethod.GET)
	public ResponseEntity<?> listar(@PathVariable Integer id) throws Exception {
			Cliente objeto = categoriaService.buscarPorId(id);
			
	return ResponseEntity.ok(objeto);		
		
	}	
}
	
	

