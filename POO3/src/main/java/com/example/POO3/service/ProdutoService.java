package com.example.POO3.service;

import com.example.POO3.model.Fornecedor;
import com.example.POO3.model.Produto;

import java.util.List;

public interface ProdutoService {
    Produto adicionarProduto(Produto produto);
    
    List<Produto> buscarProdutosPorCategoria(Long categoriaId);
    
    List<Fornecedor> buscarFornecedoresPorProduto(Long idProduto);

	List<Produto> listarProdutos();
	
	Produto buscarProdutoPorId(Long id);
}
