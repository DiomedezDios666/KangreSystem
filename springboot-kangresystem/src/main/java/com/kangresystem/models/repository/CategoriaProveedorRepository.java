package com.kangresystem.models.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kangresystem.models.entity.CategoriaProveedor;

@Repository
public interface CategoriaProveedorRepository extends CrudRepository<CategoriaProveedor, Long> {

}
