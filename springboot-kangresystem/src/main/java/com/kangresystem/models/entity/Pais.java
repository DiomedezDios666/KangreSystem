package com.kangresystem.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Paises")
public class Pais implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Integer idPais;
	private String pais;
	public Integer getIdPais() {
		return idPais;
	}
	public void setIdPais(Integer idPais) {
		this.idPais = idPais;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	@Override
	public String toString() {
		return "Pais [idPais=" + idPais + ", pais=" + pais + "]";
	}
	
	
}
