package com.ProyectoATOS.app.variables;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name="entrenadores")

public class Entrenadores {
	@Id
	@Column (name="id")
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Integer Id;
	
	@NotEmpty
	private String nombre;
	
	@NotEmpty
	private String apellido;
	
	@NotNull
	private int edad;
	
	@NotEmpty
	private String nacionalidad;

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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
}
