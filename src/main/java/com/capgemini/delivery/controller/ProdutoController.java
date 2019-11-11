package com.capgemini.delivery.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProdutoController {

    @GetMapping("/batatas")
    @ResponseBody
    public String[] buscatTodasBatatas() {
        String[] batatas = {"Batata1", "Batata2"};
        return batatas;
    }
    
//    @GetMapping("/adicionais")
//    @ResponseBody
//    public List buscatTodosAdicionais() {
//        List adicionais = new ArrayList();
//        
//        ???? adicional1 = new ?????();
//        
//		adicionais.add(adicional1);
//        adicionais.add(adicional2);
//        adicionais.add(adicional3);
//        return adicionais;
//    }
}