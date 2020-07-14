package com.kangresystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kangresystem.models.entity.Cliente;
import com.kangresystem.models.service.IClienteService;

@Controller
@RequestMapping("/Views/SI/Usuarios/Cliente")
public class ClienteController {
	
	@Autowired
	private IClienteService clienteService;
	
	@GetMapping("/")
	public String listarClientes(Model model) {
		List<Cliente> listadoClientes = clienteService.listarClientes();
		
		model.addAttribute("titulo", "Listado de clientes");
		model.addAttribute("clientes", listadoClientes);
		return "/Views/SI/Usuarios/Cliente/tablaClientes";
	}

}
