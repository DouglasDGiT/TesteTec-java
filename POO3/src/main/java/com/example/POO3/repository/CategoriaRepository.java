package com.example.POO3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.POO3.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
