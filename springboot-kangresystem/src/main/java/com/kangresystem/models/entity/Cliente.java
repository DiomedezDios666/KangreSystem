package com.kangresystem.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Clientes")
public class Cliente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_cliente")
	private Long idCliente;
	
	@Column(name="numero_doc")
    private Long numeroDoc;
	
	@Column(name="tipo_doc")
    private String tipoDoc;
    private String nombres;
    private String apellidos;
    private String celular;
    private Character genero;
    private String telefono;
    private String direccion;
    private String ciudad;
    private String email;
    
    @Column(name="fecha_nac")
    private Date fechaNac;
    private Integer edad;
    
    @Column(name="fecha_registro")
    private Date fechaRegistro;
    private String estado;
    private String antiguedad;
    private int kangrepuntos;
    
    @ManyToOne
    @JoinColumn(name="id_pais")
    private Pais pais;

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public Long getNumeroDoc() {
		return numeroDoc;
	}

	public void setNumeroDoc(Long numeroDoc) {
		this.numeroDoc = numeroDoc;
	}

	public String getTipoDoc() {
		return tipoDoc;
	}

	public void setTipoDoc(String tipoDoc) {
		this.tipoDoc = tipoDoc;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public Character getGenero() {
		return genero;
	}

	public void setGenero(Character genero) {
		this.genero = genero;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getAntiguedad() {
		return antiguedad;
	}

	public void setAntiguedad(String antiguedad) {
		this.antiguedad = antiguedad;
	}

	public int getKangrepuntos() {
		return kangrepuntos;
	}

	public void setKangrepuntos(int kangrepuntos) {
		this.kangrepuntos = kangrepuntos;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", numeroDoc=" + numeroDoc + ", tipoDoc=" + tipoDoc + ", nombres="
				+ nombres + ", apellidos=" + apellidos + ", celular=" + celular + ", genero=" + genero + ", telefono="
				+ telefono + ", direccion=" + direccion + ", ciudad=" + ciudad + ", email=" + email + ", fechaNac="
				+ fechaNac + ", edad=" + edad + ", fechaRegistro=" + fechaRegistro + ", estado=" + estado
				+ ", antiguedad=" + antiguedad + ", kangrePuntos=" + kangrepuntos + ", pais=" + pais + "]";
	}
    
    

}
