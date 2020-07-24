package com.kangresystem.models.service;

import java.util.List;

import com.kangresystem.models.entity.Producto;

public interface IProductoService {
	
	public List<Producto> findAllByViaProd();
	
	public void guardar(Producto producto);
	
	public Producto buscarPorId(Long idProducto);
	
	public void eliminar(Long idProducto);
	
	public boolean existePorId(Long idProducto);
	
}
