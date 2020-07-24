package com.kangresystem.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kangresystem.excel.ProveedorExcelExporter;
import com.kangresystem.models.entity.CategoriaProveedor;
import com.kangresystem.models.entity.Proveedor;
import com.kangresystem.models.service.ICategoriaProveedorService;
import com.kangresystem.models.service.IProveedorService;

@Controller 
@RequestMapping("/proveedor")
public class ProveedorController {
	
	private List<Proveedor> proveedores = new ArrayList<>();
	
	@Autowired
	private ICategoriaProveedorService categoriaService;
		
	@Autowired
	private IProveedorService proveedorService;
	
	@PostMapping("/")
	public String filtrar(@ModelAttribute Proveedor proveedor,@Param("nombre") String nombre,
			@Param("ciudad") String ciudad, @Param("estado") String estado, Model model) {
		
		proveedores = proveedorService.buscarPorNombreCiudadEstado(nombre, ciudad, estado);
		model.addAttribute("proveedores", proveedores);	
		model.addAttribute("Titulo", "Proveedores");
		return "/Views/SI/Proveedores/listarProveedores";
	}
	
	
	@GetMapping("/")
	public String listarProveedores(Model model) {
		List<Proveedor> listadoProveedores = proveedorService.findAllByViaProc();
		
		model.addAttribute("proveedor", new Proveedor());
		model.addAttribute("categorias", categoriaService.listaCategorias());
		model.addAttribute("Titulo", "Proveedores");
		model.addAttribute("proveedores", listadoProveedores);
		
		return "/Views/SI/Proveedores/listarProveedores";
	}
	
	
	@GetMapping("/export") 
  	public void exportToExcel(HttpServletResponse response) throws IOException {
	    response.setContentType("application/octet-stream"); 
	    String headerKey = "Content-disposition"; 
	    String headerValue = "attachment; filename=Proveedor.xlsx";
		  
	    response.setHeader(headerKey, headerValue);
	    
	    if (proveedores == null) {
	    	
	    	proveedores = proveedorService.findAllByViaProc();
			
		}
		  
	    ProveedorExcelExporter excelExporter = new ProveedorExcelExporter(proveedores); excelExporter.export(response); 
    }
	
	@GetMapping("/crear")
	public String crear(Model model) {
		
		model.addAttribute("titulo", "Formulario: Nuevo Proveedor");
		model.addAttribute("proveedor", new Proveedor());
		model.addAttribute("categorias", categoriaService.listaCategorias());
		
		return "/Views/SI/Proveedores/frmCrear";
	}	
	
	@PostMapping("/crear")
	public String guardar(@Valid @ModelAttribute("proveedor") Proveedor proveedor, BindingResult result, ModelMap model, RedirectAttributes attribute) {
		model.addAttribute("categorias", categoriaService.listaCategorias());
		if (result.hasErrors()) {	
			
			return "/Views/SI/Proveedores/frmCrear";
					
		}else {
			proveedorService.guardar(proveedor);
			attribute.addFlashAttribute("success", "Producto creado con exito!");
			return "redirect:/proveedor/";
		}
		
	}
	
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable ("id") Long idProveedor, Model model, RedirectAttributes attribute) {
		
		Proveedor proveedor = proveedorService.buscarPorId(idProveedor);
		List<CategoriaProveedor> listCategorias = categoriaService.listaCategorias();
		
		model.addAttribute("titulo", "Formulario: Editar Proveedor");
		model.addAttribute("proveedor", proveedor);
		model.addAttribute("categorias", listCategorias);
		
		attribute.addFlashAttribute("success", "Producto editado con exito!");
		return "/Views/SI/Proveedores/frmCrear";
	}
	
	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable ("id") Long idProveedor, RedirectAttributes attribute) {
		
		proveedorService.eliminar(idProveedor);
		attribute.addFlashAttribute("success", "Proveedor eliminado con exito!");
		
		return "redirect:/proveedor/";
	}
	
	
	
	
	
	
	
}
