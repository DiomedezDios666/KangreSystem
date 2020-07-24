package com.kangresystem.models.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kangresystem.models.entity.CategoriaProducto;

@Repository
public interface CategoriaProductoRepository extends CrudRepository<CategoriaProducto, Long> {

}
