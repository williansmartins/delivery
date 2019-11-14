package com.capgemini.delivery.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.capgemini.delivery.model.Produto;
import com.capgemini.delivery.model.Tipo;

public interface ProdutoRepository extends CrudRepository<Produto, Long> {
	public List<Produto> findByTipo(Tipo tipo);

	
	
	
}