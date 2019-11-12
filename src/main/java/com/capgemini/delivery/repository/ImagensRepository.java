package com.capgemini.delivery.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.capgemini.delivery.model.Imagem;

public interface ImagensRepository extends CrudRepository<Imagem, Long> {
	public List<Imagem>findAllByUrlIgnoreCaseContaining(String url);
}