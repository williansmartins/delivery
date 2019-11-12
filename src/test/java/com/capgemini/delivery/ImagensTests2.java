package com.capgemini.delivery;

import java.util.Optional;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.delivery.model.Imagem;
import com.capgemini.delivery.repository.ImagensRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ImagensTests2 {

	@Autowired
	ImagensRepository imagemRepository;
	
	@Test
	public void inserirExcluir() {
		Imagem imagem = new Imagem();
		imagem.setUrl("https://www.placecage.com/100/100");
		Assert.assertNull(imagem.getId());
		
		imagemRepository.save(imagem);
		Assert.assertNotNull(imagem.getId());
		
//		imagemRepository.deleteById(imagem.getId());
//		
//		Optional<Imagem> imagemDoBanco = imagemRepository.findById(imagem.getId());
//		Assert.assertEquals(imagemDoBanco, Optional.empty());
	}
	
	@Test
	public void atualizarBuscarUm() {
		Imagem imagem = new Imagem();
		imagem.setUrl("https://www.placecage.com/100/100");
		Assert.assertNull(imagem.getId());
		
		//inserindo no banco
		imagemRepository.save(imagem);
		Assert.assertNotNull(imagem.getId());
		
		//trocando a url
		String urlNova = "https://www.placecage.com/100/100";
		imagem.setUrl(urlNova);
		
		//buscar no banco
		Optional<Imagem> imagemDoBanco = imagemRepository.findById(imagem.getId());
		Assert.assertNotEquals(imagemDoBanco.get().getUrl(), urlNova);
		
		imagemRepository.deleteById(imagem.getId());
	}
	

}