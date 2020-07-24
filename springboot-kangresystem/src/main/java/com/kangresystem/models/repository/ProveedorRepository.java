package com.kangresystem.models.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kangresystem.models.entity.Proveedor;

@Repository
public interface ProveedorRepository extends CrudRepository<Proveedor, Long> {
	
	public List<Proveedor> findByNombreAndCiudadAndEstadoContaining(String nombre, String ciudad, String estado);
	public List<Proveedor> findByEstado(String estado);
	public List<Proveedor> findByCiudad(String ciudad);
	public List<Proveedor> findByNombreContaining(String nombre);
	public List<Proveedor> findByCiudadAndEstado(String ciudad, String estado);
	public List<Proveedor> findByNombreAndCiudadContaining(String nombre, String ciudad);
	public List<Proveedor> findByNombreAndEstadoContaining(String nombre, String estado);

}
