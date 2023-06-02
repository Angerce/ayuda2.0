package com.Producto.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Producto.DAO.CategoriaRepository;
import com.Producto.Entity.Categoria;

@Service
public class CategoriaServices {

	@Autowired
	private CategoriaRepository repo;
	
	public List<Categoria> listaTodo(){
		return repo.findAll();
	}
}
