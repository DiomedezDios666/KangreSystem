package com.kangresystem.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kangresystem.models.entity.Proveedor;
import com.kangresystem.models.repository.ProveedorRepository;
import com.kangresystem.models.service.IProveedorService;

@Service
public class ProveedorServiceImp implements IProveedorService {
	
	@Autowired
	private EntityManager entityManager;
	
	@Autowired
	private ProveedorRepository proveedorRepository;

	@Override
	public void guardar(Proveedor proveedor) {
		proveedorRepository.save(proveedor);
	}

	@Override
	public Proveedor buscarPorId(Long id) {
		return proveedorRepository.findById(id).orElse(null);
	}

	@Override
	public void eliminar(Long id) {
		proveedorRepository.deleteById(id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Proveedor> findAllByViaProc() {
		StoredProcedureQuery storedProcedureQuery = this.entityManager.createNamedStoredProcedureQuery("getAllProveedores");
		storedProcedureQuery.execute();
		return storedProcedureQuery.getResultList();
	}
	
	
	@Override
	public List<Proveedor> buscarPorNombreCiudadEstado(String nombre, String ciudad, String estado) {
		if (nombre != "" && ciudad != "" && estado != "") {
			return proveedorRepository.findByNombreAndCiudadAndEstadoContaining(nombre, ciudad, estado);
		}
		if (nombre == "" && ciudad == "" && estado != "") {
			return proveedorRepository.findByEstado(estado);
		}
		if (nombre == "" && ciudad != "" && estado == "") {
			return proveedorRepository.findByCiudad(ciudad);
		}
		if (nombre != "" && ciudad == "" && estado == "") {
			return proveedorRepository.findByNombreContaining(nombre);
		}
		if (nombre == "" && ciudad != "" && estado != "") {
			return proveedorRepository.findByCiudadAndEstado(ciudad, estado);
		}
		if (nombre != "" && ciudad != "" && estado == "") {
			return proveedorRepository.findByNombreAndCiudadContaining(nombre, ciudad);
		}
		if (nombre != "" && ciudad == "" && estado != "") {
			return proveedorRepository.findByNombreAndEstadoContaining(nombre, estado);
		}
		return (List<Proveedor>) findAllByViaProc();
	}
	
	@Override
	public List<Proveedor> buscarPorNombreCiudad(String nombre, String ciudad) {
		return proveedorRepository.findByNombreAndCiudadContaining(nombre, ciudad);
	}
	
	@Override
	public List<Proveedor> buscarPorNombreEstado(String nombre, String estado) {
		return proveedorRepository.findByNombreAndEstadoContaining(nombre, estado);
	}
	
	@Override
	public List<Proveedor> buscarPorNombre(String nombre) {
		return proveedorRepository.findByNombreContaining(nombre);
	}
	
	@Override
	public List<Proveedor> buscarPorCiudadEstado(String ciudad, String estado) {
		return proveedorRepository.findByCiudadAndEstado(ciudad, estado);
	}
	
	@Override
	public List<Proveedor> buscarPorEstado(String estado) {
		return proveedorRepository.findByEstado(estado);
	}

	@Override
	public List<Proveedor> buscarPorCiudad(String ciudad) {
		return proveedorRepository.findByCiudad(ciudad);
	}
	

}
