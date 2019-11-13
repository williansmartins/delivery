package com.capgemini.delivery.repository;

import org.springframework.data.repository.CrudRepository;

import com.capgemini.delivery.model.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Long> {

}