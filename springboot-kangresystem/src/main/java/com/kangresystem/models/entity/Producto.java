package com.kangresystem.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@NamedStoredProcedureQuery(name="getAllProductos", procedureName = "get_all_productos", resultClasses = {Producto.class})
@Table(name="productos")
public class Producto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_producto")
	private Long idProducto;
	@NotNull
	@Size(min=1, message="Campo requerido.")
	@Column(name="cod_barra")
	private String codBarra;
	@NotNull
	@Size(min=1, message="Campo requerido.")
	@Column(name="nombre_producto")
	private String nombreProducto;
	@NotNull
	@Size(min=1, message="Campo requerido.")
	private String detalle;
	@Column(name="precio_venta")
	private Long precioVenta;
	@ManyToOne
	@JoinColumn(name="id_categoria")
	private CategoriaProducto categoriaProducto;
	private String estado;
	
	public Producto() {
		this.estado = "ACTIVO";
	}
	
	public Long getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}
	public String getCodBarra() {
		return codBarra;
	}
	public void setCodBarra(String codBarra) {
		this.codBarra = codBarra;
	}
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	public Long getPrecioVenta() {
		return precioVenta;
	}
	public void setPrecioVenta(Long precioVenta) {
		this.precioVenta = precioVenta;
	}
	public CategoriaProducto getCategoriaProducto() {
		return categoriaProducto;
	}
	public void setCategoriaProducto(CategoriaProducto categoriaProducto) {
		this.categoriaProducto = categoriaProducto;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	@Override
	public String toString() {
		return "Producto [idProducto=" + idProducto + ", codBarra=" + codBarra + ", nombreProducto=" + nombreProducto
				+ ", detalle=" + detalle + ", precioVenta=" + precioVenta + ", categoriaProducto=" + categoriaProducto + ", estado="
				+ estado + "]";
	}

	
	
	
}
