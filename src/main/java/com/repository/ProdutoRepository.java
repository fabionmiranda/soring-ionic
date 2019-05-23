package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.models.Produtos;

@Repository
public interface ProdutoRepository extends JpaRepository<Produtos, Integer>{
	
}


