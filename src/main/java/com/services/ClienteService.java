package com.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.models.Cliente;
import com.repository.ClienteRepository;

import javassist.NotFoundException;

@Service
public class ClienteService {
	
	//metodo para buscar no repository as acoes do Crud por meio 
	//de DI - Injeção dependencia / Inversão de Controle - categoriaRepository - @Autowired
	
	@Autowired
	private ClienteRepository categoriaRepository;	
	
	//buscar categoria por id
	public Cliente buscarPorId(Integer id) throws Exception   {
		Cliente objeto = categoriaRepository.findOne(id); // se o id não existe ele retorna null.	
		//tratamento objeto = null então há excessao
		if (objeto == null) {
			throw new NotFoundException("Objeto não encontrado Id :" + id + "Tipo" + Cliente.class.getName());
		}
	return objeto;
		
	}

}
