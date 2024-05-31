package com.ProyectoATOS.app.variables;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name="asociacion")

public class Asociacion {
	
	@Id
	@Column(name="id")
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Integer Id;
	
	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getPresidente() {
		return presidente;
	}

	public void setPresidente(String presidente) {
		this.presidente = presidente;
	}

	@NotEmpty
	private String nombre;
	
	@NotEmpty
	private String pais;
	
	@NotEmpty
	private String presidente;

}
