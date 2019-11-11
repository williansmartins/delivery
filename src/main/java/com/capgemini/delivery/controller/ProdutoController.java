package com.capgemini.delivery.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.capgemini.delivery.dao.ProdutoDAO;
import com.capgemini.delivery.model.Batata;
import com.capgemini.delivery.model.Produto;

@Controller
public class ProdutoController {

	private static ProdutoDAO dao = new ProdutoDAO();

	@GetMapping("/batatas")
    @ResponseBody
    public List<Batata> buscarTodasBatatas() {
		List<Batata> batatas = dao.buscarBatatas();
		return batatas;
    }
    
    @GetMapping("/adicionais")
    @ResponseBody
    public List<Produto> buscarTodosAdicionais() {
        List<Produto> adicionais = dao.buscarTodosAdicionais();
        return adicionais;
    }

    void buscarUmaBatata(int id) {
    	//TODO: implementar metodo
    }

}