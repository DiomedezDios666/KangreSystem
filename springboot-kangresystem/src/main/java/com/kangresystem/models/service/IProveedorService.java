package com.kangresystem.models.service;

import java.util.List;

import com.kangresystem.models.entity.Proveedor;


public interface IProveedorService {
	
	public List<Proveedor> findAllByViaProc();
	
	public void guardar (Proveedor proveedor);
	
	public Proveedor buscarPorId(Long id);
	
	public void eliminar (Long id); 
	
	public List<Proveedor> buscarPorNombreCiudadEstado(String nombre, String ciudad, String estado);
	public List<Proveedor> buscarPorNombreCiudad(String nombre, String ciudad);
	public List<Proveedor> buscarPorNombreEstado(String nombre, String estado);
	public List<Proveedor> buscarPorNombre(String nombre);
	public List<Proveedor> buscarPorCiudadEstado(String ciudad, String estado);
	public List<Proveedor> buscarPorEstado(String estado);
	public List<Proveedor> buscarPorCiudad(String ciudad);

}
