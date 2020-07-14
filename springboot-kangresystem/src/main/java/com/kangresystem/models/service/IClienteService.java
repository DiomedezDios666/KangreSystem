package com.kangresystem.models.service;

import java.util.List;

import com.kangresystem.models.entity.Cliente;


public interface IClienteService {
	
	public List<Cliente> listarClientes();
	
	public void guardar(Cliente cliente);
	
	public Cliente buscarPorId(Long id);
	
	public void eliminar (Long id);

}
