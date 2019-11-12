package com.capgemini.delivery;

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
public class ImagensTests {

	@Autowired
	ImagensRepository imagemRepository;
	
	@Test
	public void inserirExcluir() {
		Imagem imagem = new Imagem();
		imagem.setUrl("https://www.placecage.com/100/100");
		Assert.assertNull(imagem.getId());
		
		imagemRepository.save(imagem);
		Assert.assertNotNull(imagem.getId());
		
	}

}