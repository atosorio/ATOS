package com.ProyectoATOS.app.variables;


import java.util.List;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name="club")

public class Club {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer Id;
	
	@NotEmpty
	private String nombre;
	
	
	@OneToOne
	private Entrenadores entrenadores;
	
	@OneToMany
	@JoinColumn(name="id_club")
	private List<Jugadores>jugadores;
	
	@ManyToOne
	@JoinColumn(name="asociacion_id")
	private Asociacion asociacion;
	
	@ManyToMany
	private List<Competiciones>competiciones;

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

	public Entrenadores getEntrenadores() {
		return entrenadores;
	}

	public void setEntrenadores(Entrenadores entrenadores) {
		this.entrenadores = entrenadores;
	}

	public List<Jugadores> getJugadores() {
		return jugadores;
	}

	public void setJugadores(List<Jugadores> jugadores) {
		this.jugadores = jugadores;
	}

	public Asociacion getAsociacion() {
		return asociacion;
	}

	public void setAsociacion(Asociacion asociacion) {
		this.asociacion = asociacion;
	}

	public List<Competiciones> getCompeticiones() {
		return competiciones;
	}

	public void setCompeticiones(List<Competiciones> competiciones) {
		this.competiciones = competiciones;
	}

}
