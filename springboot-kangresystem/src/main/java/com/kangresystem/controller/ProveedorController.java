package com.kangresystem.controller;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kangresystem.models.entity.Proveedor;
import com.kangresystem.models.service.IProveedorService;

@Controller 
@RequestMapping("/Views/SI/Proveedores")
public class ProveedorController {
	
	@Autowired
	private IProveedorService proveedorService;
	
	@GetMapping("/")
	public String listarClientes(Model model) {
		List<Proveedor> listadoProveedores = proveedorService.listarProveedores();
		
		model.addAttribute("Titulo", "Lista Proveedores");
		model.addAttribute("proveedores", listadoProveedores);
		
		return "/Views/SI/Proveedores/listarProveedores";
	}
	
	@GetMapping("/create")
	public String crear() {
		
		return "/Views/SI/Proveedores/frmCrear";
	}
	
	@GetMapping("/export/all")
	public ResponseEntity<InputStreamResource> exportAllData() throws Exception{
		ByteArrayInputStream stream = proveedorService.exportAllData();
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment; filename=Proveedores.xls");
		
		return ResponseEntity.ok().headers(headers).body(new InputStreamResource(stream));
	}
	
}
