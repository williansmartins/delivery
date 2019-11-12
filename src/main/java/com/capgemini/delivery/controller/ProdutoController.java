package com.capgemini.delivery.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.capgemini.delivery.dao.ProdutoDAO;
import com.capgemini.delivery.model.Batata;
import com.capgemini.delivery.model.Bebida;
import com.capgemini.delivery.model.Produto;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

	private static ProdutoDAO dao = new ProdutoDAO();

	@RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public List<Produto> buscarTodosProdutos() {
		List<Produto> produtos = dao.buscarTodos();
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

//    @GetMapping("{id}")
//    @ResponseBody
//    Batata buscarUmProduto(@PathVariable int id) {
//    	System.out.println(">>>>" + id);
//    	Batata batata = dao.buscarBatata(id);
//    	return batata;
//    }
//    
//    @RequestMapping(method = RequestMethod.DELETE)
//    @ResponseBody
//    Batata buscarUmaBatata(@PathVariable int id) {
//    	System.out.println(">>>>" + id);
//    	Batata batata = dao.buscarBatata(id);
//    	return batata;
//    }

}