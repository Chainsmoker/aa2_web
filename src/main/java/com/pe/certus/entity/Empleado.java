package com.pe.certus.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="empleado")
public class Empleado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="chr_emplcodigo")
	private Long id;

	@Column(name="vch_emplpaterno")
	private String paterno;

	@Column(name="vch_emplmaterno")
	private String materno;

	@Column(name="vch_emplnombre")
	private String nombre;

	@Column(name="vch_emplusuario")
	private String usuario;

	@Column(name="chr_emplciudad")
	private String ciudad;

	@Column(name="vch_emplcorreo")
	private String correo;

	@Column(name="vch_emplespecialidad")
	private String especialidad;


	public Empleado() {
		super();
	}

	public Empleado(Long id, String paterno, String materno, String nombre, String usuario, String ciudad, String correo,
			String especialidad) {
		super();
		this.id = id;
		this.paterno = paterno;
		this.materno = materno;
		this.nombre = nombre;
		this.usuario = usuario;
		this.ciudad = ciudad;
		this.correo = correo;
		this.especialidad = especialidad;
	}

	public Long getId() {
		return id;
	}

	public String getPaterno() {
		return paterno;
	}

	public String getMaterno() {
		return materno;
	}

	public String getNombre() {
		return nombre;
	}

	public String getUsuario() {
		return usuario;
	}

	public String getCiudad() {
		return ciudad;
	}

	public String getCorreo() {
		return correo;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setPaterno(String paterno) {
		this.paterno = paterno;
	}

	public void setMaterno(String materno) {
		this.materno = materno;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	@Override
	public String toString() {
		return "Empleado [id=" + id + ", paterno=" + paterno + ", materno=" + materno + ", nombre=" + nombre
				+ ", usuario=" + usuario + ", ciudad=" + ciudad + ", correo=" + correo + ", especialidad=" + especialidad
				+ "]";
	}
}
