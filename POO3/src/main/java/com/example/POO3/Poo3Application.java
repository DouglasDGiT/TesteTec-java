package com.example.POO3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.POO3.model.Categoria;
import com.example.POO3.model.Fornecedor;
import com.example.POO3.model.Produto;
import com.example.POO3.service.CategoriaService;
import com.example.POO3.service.FornecedorService;
import com.example.POO3.service.ProdutoService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class Poo3Application implements CommandLineRunner {

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private ProdutoService produtoService;


    public static void main(String[] args) {
        SpringApplication.run(Poo3Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        
    	Categoria categoria = new Categoria();
    	categoria.setNome("Materiais");
    	
    	Categoria categoria2 = new Categoria();
    	categoria2.setNome("Eletrônicos");
    	
    	Categoria categoria3 = new Categoria();
    	categoria3.setNome("Mobílias");
    	
    	// Adicionar a categoria usando o serviço
    	categoria = categoriaService.adicionarCategoria(categoria);
    	categoria2 = categoriaService.adicionarCategoria(categoria2);
    	categoria3 = categoriaService.adicionarCategoria(categoria3);
    	
    	// Criar produtos
    	Produto produto1 = new Produto();
    	produto1.setNome("Pedra");
    	produto1.setCategoria(categoria); // Associar o produto à categoria criada

    	Produto produto2 = new Produto();
    	produto2.setNome("Madeira");
    	produto2.setCategoria(categoria); // Associar o produto à categoria criada
    	
    	Produto produto3 = new Produto();
    	produto3.setNome("Notebook");
    	produto3.setCategoria(categoria2);

    	Produto produto4 = new Produto();
    	produto4.setNome("Mesa");
    	produto4.setCategoria(categoria3);
    	
    	// Adicionar produtos usando o serviço
    	produtoService.adicionarProduto(produto1);
    	produtoService.adicionarProduto(produto2);
    	produtoService.adicionarProduto(produto3);
    	produtoService.adicionarProduto(produto4);
    	
    	// Buscar todas as categorias e seus produtos
        List<Categoria> categorias = categoriaService.listarCategorias();
        categorias.forEach(c -> {
            System.out.println("Categoria: " + c.getNome());

            // Buscar produtos por categoria
            List<Produto> produtos = produtoService.buscarProdutosPorCategoria(c.getId());
            System.out.println("Produtos da categoria \"" + c.getNome() + "\":");
            produtos.forEach(p -> System.out.println(" - " + p.getNome() + " | Categoria: " + p.getCategoria().getNome()));
        });

        // Buscar todos os produtos
        List<Produto> todosProdutos = produtoService.listarProdutos();
        System.out.println("Todos os produtos:");
        todosProdutos.forEach(p -> System.out.println(" - " + p.getNome() + " | Categoria: " + p.getCategoria().getNome()));

    }   
}

