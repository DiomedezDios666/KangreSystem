package com.kangresystem.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kangresystem.models.entity.CategoriaProducto;
import com.kangresystem.models.repository.CategoriaProductoRepository;
import com.kangresystem.models.service.ICategoriaProductoService;

@Service
public class CategoriaProductoServiceImp implements ICategoriaProductoService {
	
	@Autowired
	private CategoriaProductoRepository categoriaRepository;

	@Override
	public List<CategoriaProducto> listarCategorias() {
		return (List<CategoriaProducto>) categoriaRepository.findAll();
	}

	@Override
	public CategoriaProducto buscarPorId(Long idProducto) {
		return categoriaRepository.findById(idProducto).orElse(null);
	}

}
