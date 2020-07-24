package com.kangresystem.excel;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.kangresystem.models.entity.Proveedor;

public class ProveedorExcelExporter {
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	
	private List<Proveedor> listarProveedores;

	public ProveedorExcelExporter(List<Proveedor> listarProveedores) {
		this.listarProveedores = listarProveedores;
		workbook = new XSSFWorkbook();
		sheet = workbook.createSheet("Proveedores"); 
	}


	private void writeHeaderRow() {
		Row row = sheet.createRow(0);
		
		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(16);
		style.setFont(font);
		
		Cell cell = row.createCell(0);
		cell.setCellValue("nitProveedor");
		cell.setCellStyle(style);
		
		cell = row.createCell(1);
		cell.setCellValue("Nombre");
		cell.setCellStyle(style);
		
		cell = row.createCell(2);
		cell.setCellValue("Telefono");
		cell.setCellStyle(style);
		
		cell = row.createCell(3);
		cell.setCellValue("Celular");
		cell.setCellStyle(style);
		
		cell = row.createCell(4);
		cell.setCellValue("E-Mail");
		cell.setCellStyle(style);
		
		cell = row.createCell(5);
		cell.setCellValue("Ciudad");
		cell.setCellStyle(style);
		
		cell = row.createCell(6);
		cell.setCellValue("Dirección");
		cell.setCellStyle(style);
		
		cell = row.createCell(7);
		cell.setCellValue("Categoria");
		cell.setCellStyle(style);
		
		cell = row.createCell(8);
		cell.setCellValue("Estado");
		cell.setCellStyle(style);
	}

	
	private void writeDataRows() {
		int rowCount = 1;
		
		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);
		
		for (Proveedor proveedor : listarProveedores) {
			Row row = sheet.createRow(rowCount++);
			
			Cell cell = row.createCell(0);
			cell.setCellValue(proveedor.getNitProveedor());
			sheet.autoSizeColumn(0);
			cell.setCellStyle(style);
			
			cell = row.createCell(1);
			cell.setCellValue(proveedor.getNombre());
			sheet.autoSizeColumn(1);
			cell.setCellStyle(style);
			
			cell = row.createCell(2);
			cell.setCellValue(proveedor.getTelefono());
			sheet.autoSizeColumn(2);
			cell.setCellStyle(style);
			
			cell = row.createCell(3);
			cell.setCellValue(proveedor.getCelular());
			sheet.autoSizeColumn(3);
			cell.setCellStyle(style);
			
			cell = row.createCell(4);
			cell.setCellValue(proveedor.getEmail());
			sheet.autoSizeColumn(4);
			cell.setCellStyle(style);
			
			cell = row.createCell(5);
			cell.setCellValue(proveedor.getCiudad());
			sheet.autoSizeColumn(5);
			cell.setCellStyle(style);
			
			cell = row.createCell(6);
			cell.setCellValue(proveedor.getDireccion());
			sheet.autoSizeColumn(6);
			cell.setCellStyle(style);
			
			cell = row.createCell(7);
			cell.setCellValue(proveedor.getCategoriaProveedor().getCategoria());
			sheet.autoSizeColumn(7);
			cell.setCellStyle(style);
			
			cell = row.createCell(8);
			cell.setCellValue(proveedor.getEstado());
			sheet.autoSizeColumn(8);
			cell.setCellStyle(style);
		}
		
	}
	
	
	public void export(HttpServletResponse response) throws IOException {
		writeHeaderRow();
		writeDataRows();
		
		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();
		outputStream.close();
	}
}
