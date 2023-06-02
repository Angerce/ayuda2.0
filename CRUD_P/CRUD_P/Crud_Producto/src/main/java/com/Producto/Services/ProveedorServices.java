package com.Producto.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Producto.DAO.ProveedorRepository;
import com.Producto.Entity.Proveedor;

@Service
public class ProveedorServices {
	@Autowired
	private ProveedorRepository repo;
	
	public List<Proveedor> listaTodo(){
		return repo.findAll();
	}
}
