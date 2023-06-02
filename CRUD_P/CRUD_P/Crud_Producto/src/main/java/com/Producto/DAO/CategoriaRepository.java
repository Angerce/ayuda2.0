package com.Producto.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Producto.Entity.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{

}
