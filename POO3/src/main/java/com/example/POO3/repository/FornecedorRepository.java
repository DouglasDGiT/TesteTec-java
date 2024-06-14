package com.example.POO3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.POO3.model.Fornecedor;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {
	List<Fornecedor> findByProdutos_Id(Long produtoId);
}
