package com.Producto.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="DISTRITO")
public class Distrito {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="IDDIS")
	private Integer codigo;
	@Column(name="NOMBRE")
	private String nombre;
	
	
	@OneToMany(mappedBy = "distrito")
	@JsonIgnore
	private List<Proveedor> listaProveedor;
	

	@ManyToOne
	@JoinColumn(name="IDDEP")
	private Departamento departamento;
	
}



