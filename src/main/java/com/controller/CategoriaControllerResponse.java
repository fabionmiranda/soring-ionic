package com.controller;
/*package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.models.Categoria;
import com.services.CategoriaServiceAntigo;

@RestController
@RequestMapping (value="/categorias")
public class CategoriaControllerAntigo {

	
	@Autowired
	private CategoriaServiceAntigo categoriaService;
	
	@RequestMapping(value="/{id}",  method=RequestMethod.GET)
	public ResponseEntity<?> listar(@PathVariable Integer id) {
			Categoria objeto = categoriaService.buscar(id);
			
	return ResponseEntity.ok(objeto);		
		
	}	
	
}
*/