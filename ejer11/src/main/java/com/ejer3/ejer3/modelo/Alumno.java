package com.ejer3.ejer3.modelo;

public class Alumno {
	private int id;
	private String nombre;
	private String email;
	private int edad;
	private String curso;
	private Direccion direccion;

	public Alumno(int id, String nombre, String email, int edad, String curso) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.edad = edad;
		this.curso = curso;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

}
