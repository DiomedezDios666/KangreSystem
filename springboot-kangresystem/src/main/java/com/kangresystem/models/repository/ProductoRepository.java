package com.kangresystem.models.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kangresystem.models.entity.CategoriaProducto;
import com.kangresystem.models.entity.Producto;

@Repository
public interface ProductoRepository extends CrudRepository<Producto, Long> {
	
	public Producto findByCategoriaProducto(CategoriaProducto categoriaProducto);

}
