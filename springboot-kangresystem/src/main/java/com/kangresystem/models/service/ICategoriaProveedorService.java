package com.kangresystem.models.service;

import java.util.List;

import com.kangresystem.models.entity.CategoriaProveedor;

public interface ICategoriaProveedorService {
	
	List<CategoriaProveedor> listaCategorias();

	public CategoriaProveedor buscarPorId(Long idCategoria); 

}
