package com.capgemini.delivery.dao;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.delivery.model.Batata;
import com.capgemini.delivery.model.Produto;

public class ProdutoDAO {

	List<Batata> batatas = new ArrayList<Batata>();
	List<Produto> adicionais = new ArrayList<Produto>();
	List<Produto> ingredientes = new ArrayList<Produto>();
	
	public ProdutoDAO() {
		popularMassaDeTestes();
	}

	public List<Produto> buscarTodosAdicionais() {
		return adicionais;
	}
	
	public List<Batata> buscarBatatas() {
        return batatas;
	}
	
	boolean excluirBatata(int id) {
		boolean encontrou = false;
		
		for (Batata batata : batatas) {
			if(batata.getId() == id) {
				batatas.remove(batata);
				encontrou = true;
				break;
			}
		}
		
		return encontrou;
	}
	
    
    void popularMassaDeTestes() {
    	//POPULANDO LISTA DE ADICIONAIS
    	Produto adicional1 = new Produto();
        adicional1.setTitulo("Bacon");

        Produto adicional2 = new Produto();
        adicional2.setTitulo("Ervilha");
        
        Produto adicional3 = new Produto();
        adicional3.setTitulo("Cheddar");
        
        adicionais.add(adicional1);
        adicionais.add(adicional2);
        adicionais.add(adicional3);
        
        //POPULANDO LISTA DE INGREDIENTES
        Produto ingrediente1 = new Produto();
        ingrediente1.setTitulo("Ingrediente1");

        Produto ingrediente2 = new Produto();
        adicional2.setTitulo("Ingrediente2");
        
        Produto ingrediente3 = new Produto();
        adicional3.setTitulo("Ingrediente3");
        
        ingredientes.add(ingrediente1);
        ingredientes.add(ingrediente2);
        ingredientes.add(ingrediente3);
        
        //POPULANDO LISTA DE BATATAS
        Batata batata1 = new Batata();
        batata1.setTitulo("Batata1");
		batata1.setAdicionais(adicionais);
		batata1.setIngredientes(ingredientes);
		batata1.setPreco(10.50);
		batata1.setId(123);

		Batata batata2 = new Batata();
		batata2.setTitulo("Batata2");
        batata2.setAdicionais(adicionais);
        batata2.setIngredientes(ingredientes);
        batata2.setPreco(15.50);
        batata2.setId(456);
        
        batatas.add(batata1);
        batatas.add(batata2);
    }
}
