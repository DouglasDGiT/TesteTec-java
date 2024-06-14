package com.example.POO3.service;

import com.example.POO3.model.Categoria;

import java.util.List;

public interface CategoriaService {
    Categoria adicionarCategoria(Categoria categoria);
    List<Categoria> listarCategorias();
    Categoria buscarCategoriaPorId(Long id);
}
