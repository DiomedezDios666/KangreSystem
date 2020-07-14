package com.kangresystem.models.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kangresystem.models.entity.Proveedor;

@Repository
public interface ProveedorRepository extends CrudRepository<Proveedor, Long> {

}
