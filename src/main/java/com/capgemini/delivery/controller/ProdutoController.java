package com.capgemini.delivery.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.capgemini.delivery.model.Produto;

@Controller
public class ProdutoController {

    @GetMapping("/batatas")
    @ResponseBody
    public String[] buscatTodasBatatas() {
        String[] batatas = {"Batata1", "Batata2"};
        return batatas;
    }
    
    @GetMapping("/adicionais")
    @ResponseBody
    public List buscatTodosAdicionais() {
        List adicionais = new ArrayList();
        
        Produto adicional1 = new Produto();
        adicional1.setTitulo("Bacon");

        Produto adicional2 = new Produto();
        adicional1.setTitulo("Ervilha");
        
        Produto adicional3 = new Produto();
        adicional1.setTitulo("Cheddar");
        
		adicionais.add(adicional1);
        adicionais.add(adicional2);
        adicionais.add(adicional3);
        return adicionais;
    }
}