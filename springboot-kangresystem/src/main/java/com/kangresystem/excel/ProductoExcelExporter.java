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

import com.kangresystem.models.entity.Producto;

public class ProductoExcelExporter {
	
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	
	private List<Producto> listarProductos;

	public ProductoExcelExporter(List<Producto> listarProductos) {
		this.listarProductos = listarProductos;
		workbook = new XSSFWorkbook();
		sheet = workbook.createSheet("Productos"); 
	}


	private void writeHeaderRow() {
		Row row = sheet.createRow(0);
		
		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(16);
		style.setFont(font);
		
		Cell cell = row.createCell(0);
		cell.setCellValue("codBarra");
		cell.setCellStyle(style);
		
		cell = row.createCell(1);
		cell.setCellValue("Nombre");
		cell.setCellStyle(style);
		
		cell = row.createCell(2);
		cell.setCellValue("Detalle");
		cell.setCellStyle(style);
		
		cell = row.createCell(3);
		cell.setCellValue("Precio");
		cell.setCellStyle(style);
		
		cell = row.createCell(4);
		cell.setCellValue("Categoria");
		cell.setCellStyle(style);
		
		cell = row.createCell(5);
		cell.setCellValue("Estado");
		cell.setCellStyle(style);
	}

	
	private void writeDataRows() {
		int rowCount = 1;
		
		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);
		
		for (Producto producto : listarProductos) {
			Row row = sheet.createRow(rowCount++);
			
			Cell cell = row.createCell(0);
			cell.setCellValue(producto.getCodBarra());
			sheet.autoSizeColumn(0);
			cell.setCellStyle(style);
			
			cell = row.createCell(1);
			cell.setCellValue(producto.getNombreProducto());
			sheet.autoSizeColumn(1);
			cell.setCellStyle(style);
			
			cell = row.createCell(2);
			cell.setCellValue(producto.getDetalle());
			sheet.autoSizeColumn(2);
			cell.setCellStyle(style);
			
			cell = row.createCell(3);
			cell.setCellValue(producto.getPrecioVenta());
			sheet.autoSizeColumn(3);
			cell.setCellStyle(style);
			
			cell = row.createCell(4);
			cell.setCellValue(producto.getCategoriaProducto().getCategoria());
			sheet.autoSizeColumn(4);
			cell.setCellStyle(style);
			
			cell = row.createCell(5);
			cell.setCellValue(producto.getEstado());
			sheet.autoSizeColumn(5);
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
