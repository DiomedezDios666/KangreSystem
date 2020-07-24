package com.kangresystem.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.kangresystem.excel.ProductoExcelExporter;
import com.kangresystem.models.entity.CategoriaProducto;
import com.kangresystem.models.entity.Producto;
import com.kangresystem.models.service.ICategoriaProductoService;
import com.kangresystem.models.service.IProductoService;

@Controller
@RequestMapping("/producto")
public class ProductoContoller {
	
	@Autowired
	private ICategoriaProductoService categoriaService;
	
	@Autowired
	private IProductoService productoService;
	
	@GetMapping("/")
	public String listarProductos(Model model) {
		List<Producto> listadoProductos = productoService.findAllByViaProd();
		
		model.addAttribute("producto", new Producto());
		model.addAttribute("categorias", categoriaService.listarCategorias());
		model.addAttribute("titulo", "Lista Producto");
		model.addAttribute("productos", listadoProductos);
		
		return "/Views/SI/Inventario/Productos/listarProductos";
	}
	
	@GetMapping("/crear")
	public String crear(Model model) {
		
		model.addAttribute("titulo", "Formulario: Nuevo Producto");
		model.addAttribute("producto", new Producto());
		model.addAttribute("categorias", categoriaService.listarCategorias());
		
		return "/Views/SI/Inventario/Productos/frmCrear";
	}
	
	@PostMapping("/crear")
	public String guardar(@Valid @ModelAttribute ("producto") Producto producto, BindingResult result,
			ModelMap model, RedirectAttributes attribute) {
		model.addAttribute("categorias", categoriaService.listarCategorias());
		if (result.hasErrors()) {	
			
			return "/Views/SI/Inventario/Productos/frmCrear";
					
		}else {
			productoService.guardar(producto);
			attribute.addFlashAttribute("success", "Producto guardado con exito!");
			return "redirect:/producto/";
		}
		
	}
	
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable ("id") Long idProducto, Model model, RedirectAttributes attribute) {
		
		Producto producto = productoService.buscarPorId(idProducto);
		List<CategoriaProducto> listCategorias = categoriaService.listarCategorias();
		
		model.addAttribute("titulo", "Formulario: Editar Producto");
		model.addAttribute("producto", producto);
		model.addAttribute("categorias", listCategorias);
		
		attribute.addFlashAttribute("success", "Producto guardado con exito!");
		return "/Views/SI/Inventario/Productos/frmCrear";
	}
	
	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable ("id") Long idProducto, RedirectAttributes attribute) {
		
		productoService.eliminar(idProducto);
		attribute.addFlashAttribute("success", "Producto eliminado con exito!");
		
		return "redirect:/producto/";
	}
	
	@GetMapping("/export")
	public void exportToExcel(HttpServletResponse response) throws IOException {
		response.setContentType("application/octet-stream");
		String headerKey = "Content-disposition";
		String headerValue = "attachment; filename=Producto.xlsx";
		
		response.setHeader(headerKey, headerValue);
		
		List<Producto> listarProductos = productoService.findAllByViaProd();
		
		ProductoExcelExporter excelExporter = new ProductoExcelExporter(listarProductos);
		excelExporter.export(response);	
	}

}
