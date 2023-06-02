package com.Producto.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Producto.DAO.EstadoRepository;
import com.Producto.Entity.Estado;

@Service
public class EstadoServices {
	@Autowired
	private EstadoRepository repo;
	
	public List<Estado> listaTodo(){
		return repo.findAll();
	}
}
