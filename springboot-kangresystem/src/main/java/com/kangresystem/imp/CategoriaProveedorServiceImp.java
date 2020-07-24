package com.kangresystem.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kangresystem.models.entity.CategoriaProveedor;
import com.kangresystem.models.repository.CategoriaProveedorRepository;
import com.kangresystem.models.service.ICategoriaProveedorService;

@Service
public class CategoriaProveedorServiceImp implements ICategoriaProveedorService {
	
	@Autowired
	private CategoriaProveedorRepository categoriaRepository;

	@Override
	public List<CategoriaProveedor> listaCategorias() {
		return (List<CategoriaProveedor>) categoriaRepository.findAll();
	}

	public CategoriaProveedor buscarPorId(Long idCategoria){
		return categoriaRepository.findById(idCategoria).orElse(null);
	}

}
