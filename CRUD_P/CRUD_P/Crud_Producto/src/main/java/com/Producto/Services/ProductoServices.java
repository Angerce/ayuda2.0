package com.Producto.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Producto.DAO.ProductoRepository;
import com.Producto.Entity.Producto;

@Service
public class ProductoServices {
	@Autowired
	private ProductoRepository repo;
	
	
	public void registrar(Producto p) {
		repo.save(p);
	}
	public void actualizar(Producto p) {
		repo.save(p);
	}
	public void eliminarPorID(Integer cod) {
		repo.deleteById(cod);
	}
	public Producto buscarPorID(Integer cod) {
		return repo.findById(cod).orElse(null);
	}
	public List<Producto> listarProducto(){
		return repo.findAll();
	}

}
