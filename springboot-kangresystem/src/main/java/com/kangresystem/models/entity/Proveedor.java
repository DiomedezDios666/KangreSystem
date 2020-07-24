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
@NamedStoredProcedureQuery(name = "getAllProveedores", procedureName = "get_all_proveedores", resultClasses = {Proveedor.class})
@Table(name="proveedores")
public class Proveedor implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="id_proveedor")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProveedor;
	@NotNull
	@Size(min=2, message="Campo requerido.")
	@Column(name="nit_proveedor")
	private String  nitProveedor;
	@NotNull
	@Size(min=2, message="Campo requerido.")
	private String nombre;
	@NotNull
	@Size(min=2, message="Campo requerido.")
	private String telefono;
	private String celular;
	@NotNull
	@Size(min=2, message="Campo requerido.")
	private String email;
	@NotNull
	@Size(min=2, message="Campo requerido.")
	private String ciudad;
	@NotNull
	@Size(min=2, message="Campo requerido.")
	private String direccion;
	@ManyToOne
	@JoinColumn(name="id_categoria")
	private CategoriaProveedor categoriaProveedor;
	private String estado;
	
	public Proveedor() {
		this.estado = "ACTIVO";
	}
	public Long getIdProveedor() {
		return idProveedor;
	}
	public void setIdProveedor(Long idProveedor) {
		this.idProveedor = idProveedor;
	}
	public String getNitProveedor() {
		return nitProveedor;	
	}
	public void setNitProveedor(String nitProveedor) {
		this.nitProveedor = nitProveedor;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public CategoriaProveedor getCategoriaProveedor() {
		return categoriaProveedor;
	}
	public void setCategoriaProveedor(CategoriaProveedor categoriaProveedor) {
		this.categoriaProveedor = categoriaProveedor;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	@Override
	public String toString() {
		return "Proveedor [idProveedor=" + idProveedor + ", nitProveedor=" + nitProveedor + ", nombre=" + nombre
				+ ", telefono=" + telefono + ", celular=" + celular + ", email=" + email + ", ciudad=" + ciudad
				+ ", direccion=" + direccion + ", categoriaProveedor=" + categoriaProveedor + ", estado=" + estado
				+ "]";
	}
	
	
	
	
	
	
	
	
}
