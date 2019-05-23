/* package com.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.models.Categoria;

@RestController
@RequestMapping (value="/categorias")
public class CategoriaControllerInstancia {

	@RequestMapping(method=RequestMethod.GET)
	public List<Categoria> listar() {
		//criar - instanciar 2 objetos  
		Categoria c1 =  new Categoria(1, "categoria 1");
		Categoria c2 =  new Categoria(2, "categoria 2");
		
		//criar - instanciar um array com as categorias
		List <Categoria> lista = new ArrayList<>();
		
		lista.add(c1); 
		lista.add(c2);	
		
		
		
	return lista;
		
	}
	
	
	}	
*/