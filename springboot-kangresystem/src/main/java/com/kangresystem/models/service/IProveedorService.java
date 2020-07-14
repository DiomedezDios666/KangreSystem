package com.kangresystem.models.service;

import java.io.ByteArrayInputStream;
import java.util.List;

import com.kangresystem.models.entity.Proveedor;


public interface IProveedorService {

	public List<Proveedor> listarProveedores();
	
	public void guardar (Proveedor proveedor);
	
	public Proveedor buscarPorId(Long id);
	
	public void eliminar (Long id);
	
	ByteArrayInputStream exportAllData() throws Exception;
	
}
