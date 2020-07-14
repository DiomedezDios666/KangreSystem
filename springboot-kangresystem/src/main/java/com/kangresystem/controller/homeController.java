package com.kangresystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class homeController {
	
	@GetMapping ({"/", "/index", "/home"})
	public String index () {
		return "index";
	}
	
	@GetMapping ("/contactanos")
	public String contactanos() {
		return "/Views/Index/contactanos";
	}
	
	@GetMapping ({"/Index/quienesSomos", "/quienesSomos"})
	public String quienesSomos() {
		return "/Views/Index/quienesSomos";
	}
	
	@GetMapping ({"/Index/restaurantes", "/restaurantes"})
	public String reataurantes() {
		return "/Views/Index/restaurantes";
	}
	
	@GetMapping ({"/Ingreso-Registro/registroCliente", "/registroCliente"})
	public String registroCliente() {
		return "Ingreso-Registro/registroCliente";
	}
	
	@GetMapping ({"/Ingreso-Registro/ingreso", "/ingreso"})
	public String ingreso() {
		return "Ingreso-Registro/ingreso";
	}
	
	@GetMapping ({"/Ingreso-Registro/restablecerContraseña", "/restablecerContraseña"})
	public String restablecerContraseña() {
		return "Ingreso-Registro/restablecerContraseña";
	}
	
	@GetMapping ({"/Ingreso-Registro/nuevasContraseña", "/nuevaContraseña"})
	public String nuevaContraseña() {
		return "Ingreso-Registro/nuevaContraseña";
	}
	
	@GetMapping ({"/Views/Ingreso-Registro/codigoContraseña", "/codigoContraseña"})
	public String codigoContraseña() {
		return "/Views/Ingreso-Registro/codigoContraseña";
	}
	
	@GetMapping ({"/Views/SI/Usuarios/Cliente/cliente","/cliente"})
	public String cliente() {
		return "/Views/SI/Usuarios/Cliente/cliente";
	}

}
