package com.capgemini.delivery.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.capgemini.delivery.dao.ProdutoDAO;
import com.capgemini.delivery.model.Batata;
import com.capgemini.delivery.model.Bebida;
import com.capgemini.delivery.model.Imagem;
import com.capgemini.delivery.model.Produto;
import com.capgemini.delivery.model.Tag;
import com.capgemini.delivery.repository.ImagensRepository;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

	private static ProdutoDAO dao = new ProdutoDAO();
	
	@Autowired
	private ImagensRepository imagemRepository;

	@RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public List<Produto> buscarTodosProdutos() {
		List<Produto> produtos = dao.buscarTodos();
		
		Imagem imagem = new Imagem();
		imagem.setUrl("https://www.placecage.com/100/100");
		
		
		List<Tag> tags = new ArrayList<Tag>();
		Tag tag1 = new Tag();
		tag1.setTag("MAE");
		tags.add(tag1);
		
		Tag tag2 = new Tag();
		tag2.setTag("FILHO");
		tags.add(tag2);
		imagem.setTags(tags);
		
		imagemRepository.save(imagem);
		
		return produtos;
    }
	
	@RequestMapping(value = "batatas", method = RequestMethod.GET)
    @ResponseBody
    public List<Batata> buscarTodasBatatas() {
		List<Batata> batatas = dao.buscarBatatas();
		return batatas;
    }
	
	@RequestMapping(value = "bebidas", method = RequestMethod.GET)
    @ResponseBody
    public List<Bebida> buscarTodosBebidas() {
		List<Bebida> bebidas = dao.buscarBebidas();
		return bebidas;
    }
    
	@RequestMapping(value = "adicionais", method = RequestMethod.GET)
    @ResponseBody
    public List<Produto> buscarTodosAdicionais() {
        List<Produto> adicionais = dao.buscarTodosAdicionais();
        return adicionais;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    @ResponseBody
    Produto buscarUmProduto(@PathVariable int id) {
    	System.out.println(">>>>" + id);
    	Produto produto = dao.buscarProduto(id);
    	return produto;
    }
    
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @ResponseBody
    boolean excluirProduto(@PathVariable int id) {
    	System.out.println(">>>>" + id);
    	boolean excluiu = dao.excluirProduto(id);
    	return excluiu;
    }
    
    @RequestMapping(value = "" , method = RequestMethod.POST)
    @ResponseBody
    Produto inserirProduto(@RequestBody Produto produto) {
    	return dao.inserirProduto(produto);
    }
    
    @RequestMapping(value = "{id}" , method = RequestMethod.PUT)
    @ResponseBody
    Produto atualizarProduto(@PathVariable int id,@RequestBody Produto produto) {
    	return dao.atualizarProduto(id, produto);
    }
}