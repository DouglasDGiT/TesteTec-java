package com.example.POO3.impl;

import com.example.POO3.model.Fornecedor;
import com.example.POO3.model.Produto;
import com.example.POO3.repository.ProdutoRepository;
import com.example.POO3.service.ProdutoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
public class ProdutoServiceImpl implements ProdutoService {
	
	
	 
    @Autowired
    private ProdutoRepository produtoRepository;

    @Transactional
    public Produto adicionarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }
    
   
    @Transactional(readOnly = true)
    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }
    
    
    @Transactional(readOnly = true)
    public Produto buscarProdutoPorId(Long id) {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado com ID: " + id));
    }
    @Transactional(readOnly = true)
    public List<Produto> buscarProdutosPorCategoria(Long categoriaId) {
        return produtoRepository.findByCategoriaId(categoriaId);
    }


	@Override
	@Transactional(readOnly = true)
	public List<Fornecedor> buscarFornecedoresPorProduto(Long idProduto) {
	    Produto produto = produtoRepository.findById(idProduto)
	            .orElseThrow(() -> new RuntimeException("Produto não encontrado com id: " + idProduto));
	    
	    return new ArrayList<>(produto.getFornecedores());
	}	  
    
}
