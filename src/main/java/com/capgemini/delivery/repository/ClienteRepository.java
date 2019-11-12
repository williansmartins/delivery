package com.capgemini.delivery.repository;

import org.springframework.data.repository.CrudRepository;

import com.capgemini.delivery.model.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
}