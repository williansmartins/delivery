package com.capgemini.delivery.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.capgemini.delivery.model.Produto;
import com.capgemini.delivery.model.Tipo;
import com.capgemini.delivery.repository.ProdutoRepository;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;

	@RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Produto> buscarTodosProdutos() {
		return produtoRepository.findAll();
    }
	
	@RequestMapping(value = "batatas", method = RequestMethod.GET)
    @ResponseBody
    public List<Produto> buscarTodasBatatas(String tipo) {
		List<Produto> list = produtoRepository.findByTipo(Tipo.BATATA);
		return list;
    }
	
	@RequestMapping(value = "bebidas", method = RequestMethod.GET)
    @ResponseBody
    public List<Produto> buscarTodosBebidas() {
		List<Produto> list = produtoRepository.findByTipo(Tipo.BEBIDA);
		return list;
    }
    
	@RequestMapping(value = "adicionais", method = RequestMethod.GET)
    @ResponseBody
    public List<Produto> buscarTodosAdicionais() {
		List<Produto> list = produtoRepository.findByTipo(Tipo.ADICIONAL);
		return list;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    @ResponseBody
    public Optional<Produto> buscarUmProduto(@PathVariable Long id) {
    	Optional<Produto> produto = produtoRepository.findById(id);
    	return produto;
    }
    
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void excluirProduto(@PathVariable Long id) {
    	produtoRepository.deleteById(id);
    	
    }
    
    @RequestMapping(value = "" , method = RequestMethod.POST)
    @ResponseBody
    public Produto inserirProduto(@RequestBody Produto produto) {
    	return produtoRepository.save(produto);
    }
    
    @RequestMapping(value = "{id}" , method = RequestMethod.PUT)
    @ResponseBody
    public Produto atualizarProduto(@PathVariable Long id,@RequestBody Produto produtoDoFront) {
    	tratarCampos(id, produtoDoFront);
    	return produtoRepository.save(produtoDoFront);
    }

	private void tratarCampos(Long id, Produto produtoDoFront) {
		Optional<Produto> produtoDoBack = produtoRepository.findById(id);
    	Produto produtoDoBackConvertido = produtoDoBack.get();
    	
    	if(produtoDoFront.getTitulo().isEmpty()) {produtoDoBackConvertido.setTitulo(produtoDoFront.getTitulo());};
    	if(produtoDoFront.getPreco() == 0) {produtoDoBackConvertido.setPreco(produtoDoFront.getPreco());};
    	if(produtoDoFront.getObervacao().isEmpty()) {produtoDoBackConvertido.setObervacao(produtoDoFront.getObervacao());};
    	if(produtoDoFront.getTipo() == null) {produtoDoBackConvertido.setTipo(produtoDoFront.getTipo());};
    	
    	if(produtoDoFront.getIngredientes() == null) {produtoDoBackConvertido.setIngredientes(produtoDoFront.getIngredientes());};
    	if(produtoDoFront.getAdicionais() == null) {produtoDoBackConvertido.setAdicionais(produtoDoFront.getAdicionais());};
	}
}