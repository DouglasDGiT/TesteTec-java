package com.example.POO3.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.POO3.model.Fornecedor;
import com.example.POO3.repository.FornecedorRepository;
import com.example.POO3.service.FornecedorService;

@Service
public class FornecedorServiceImpl implements FornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    @Override
    @Transactional
    public Fornecedor adicionarFornecedor(Fornecedor fornecedor) {
        return fornecedorRepository.save(fornecedor);
    }

    @Override
    @Transactional(readOnly = true)
    public Fornecedor buscarFornecedorPorId(Long id) {
        return fornecedorRepository.findById(id)
                                   .orElseThrow(() -> new RuntimeException("Fornecedor não encontrado com ID: " + id));
    }

    
}
