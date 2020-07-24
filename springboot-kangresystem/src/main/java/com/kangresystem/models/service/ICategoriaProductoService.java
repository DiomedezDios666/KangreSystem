package com.kangresystem.models.service;

import java.util.List;

import com.kangresystem.models.entity.CategoriaProducto;

public interface ICategoriaProductoService {
	
	List<CategoriaProducto> listarCategorias();
	
	public CategoriaProducto buscarPorId(Long idProducto);

}
