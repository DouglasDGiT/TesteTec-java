package com.example.POO3.service;

import com.example.POO3.model.Fornecedor;

public interface FornecedorService {
	
	Fornecedor adicionarFornecedor(Fornecedor fornecedor);

    Fornecedor buscarFornecedorPorId(Long id);

}
