package com.kangresystem.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kangresystem.models.entity.Producto;
import com.kangresystem.models.repository.ProductoRepository;
import com.kangresystem.models.service.IProductoService;

@Service
public class ProductoServiceImp implements IProductoService {
	
	@Autowired
	private ProductoRepository productoRepository;
	
	@Autowired
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Producto> findAllByViaProd() {
		StoredProcedureQuery storedProcedureQuery = this.entityManager.createNamedStoredProcedureQuery("getAllProductos");
		storedProcedureQuery.execute();
		return storedProcedureQuery.getResultList();
		
	}


	@Override
	public void guardar(Producto producto) {
		productoRepository.save(producto);
	}

	@Override
	public Producto buscarPorId(Long id) {
		return productoRepository.findById(id).orElse(null) ;
	}

	@Override
	public void eliminar(Long id) {
		productoRepository.deleteById(id);
	}

	@Override
	public boolean existePorId(Long idProducto) {
		return false;
	}

}
