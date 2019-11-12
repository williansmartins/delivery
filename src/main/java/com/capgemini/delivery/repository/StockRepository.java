package com.capgemini.delivery.repository;

import org.springframework.data.repository.CrudRepository;

import com.capgemini.delivery.model.Stock;

public interface StockRepository extends CrudRepository<Stock, Long> {
}