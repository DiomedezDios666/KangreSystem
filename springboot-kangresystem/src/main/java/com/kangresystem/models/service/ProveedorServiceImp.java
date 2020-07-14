package com.kangresystem.models.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.kangresystem.models.entity.Proveedor;
import com.kangresystem.models.repository.ProveedorRepository;

@Service
public class ProveedorServiceImp implements IProveedorService {
	
	@Autowired
	private ProveedorRepository proveedorRepository;
	
	@Override
	public List<Proveedor> listarProveedores() {
		return (List<Proveedor>) proveedorRepository.findAll() ;
	}

	@Override
	public void guardar(Proveedor proveedor) {
		 proveedorRepository.save(proveedor);
	}

	@Override
	public Proveedor buscarPorId(Long id) {
		return proveedorRepository.findById(id).orElse(null);
	}

	@Override
	public void eliminar(Long id) {
		proveedorRepository.deleteById(id);
	}
	
	private List<Proveedor> getAll() {
		List<Proveedor> listaProveedores = new ArrayList<>();
		getDao().findAll().forEach(obj -> listaProveedores.add(obj));
		return listaProveedores;
	}

	private CrudRepository<Proveedor, Long> getDao() {
		return null;
	}

	@Override
	public ByteArrayInputStream exportAllData() throws Exception {
		String[] columns = {"NIT", "Nombre", "Telefono", "Celular", "E-mail", "Ciudad", "Direccion", "Categoria", "Estado"};
		
		Workbook workbook = new HSSFWorkbook();	
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		
		Sheet sheet =workbook.createSheet("Proveedores");
		Row row = sheet.createRow(0);
		
		for (int i = 0; i < columns.length; i++) {
			Cell cell = row.createCell(i);
			cell.setCellValue(columns[i]);
		}
		
		List<Proveedor> proveedores = this.getAll();
		int initRow =1;
		for (Proveedor proveedor : proveedores) {
			row = sheet.createRow(initRow);
			row.createCell(0).setCellValue(proveedor.getNitProveedor());
			row.createCell(1).setCellValue(proveedor.getNombre());
			row.createCell(2).setCellValue(proveedor.getTelefono());
			row.createCell(3).setCellValue(proveedor.getCelular());
			row.createCell(4).setCellValue(proveedor.getEmail());
			row.createCell(5).setCellValue(proveedor.getCiudad());
			row.createCell(6).setCellValue(proveedor.getDireccion());
			row.createCell(7).setCellValue(proveedor.getCategoriaProveedor().getCategoria());
			row.createCell(8).setCellValue(proveedor.getEstado());
			
			initRow++;
		}
		
		workbook.write(stream);
		workbook.close();
		return new ByteArrayInputStream(stream.toByteArray());
	}	

}
