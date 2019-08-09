package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.models.Pagamento;

// super classe
@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Integer>{
	
}