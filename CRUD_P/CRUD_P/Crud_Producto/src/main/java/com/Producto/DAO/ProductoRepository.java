package com.Producto.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Producto.Entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer>{

}
