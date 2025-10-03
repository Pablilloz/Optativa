package com.ejer3.ejer3.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ejer3.ejer3.modelo.Alumno;

@RestController
@RequestMapping("/alumno")
public class AlumnoController {
	private List<Alumno> ListaAlumnos = new ArrayList<>();

	Alumno c1 = new Alumno(1, "Saul", "s@gmail.com", 10, "2º DAW");
	Alumno c2 = new Alumno(2, "Pablo", "p@gmail.com", 18, "2º DAW");
	Alumno c3 = new Alumno(1, "Hugo", "h@gmail.com", 10, "2º DAW");
	Alumno c4 = new Alumno(1, "Alvaro", "a@gmail.com", 10, "2º DAW");

	public void AlumnoController2() {
		// clientes = List.of(c1, c2, c3, c4);
		ListaAlumnos.add(c1);
		ListaAlumnos.add(c2);
		ListaAlumnos.add(c3);
		ListaAlumnos.add(c4);
	}

	@GetMapping()
	public List<Alumno> getAlumnos() {
		return ListaAlumnos;
	}

	@GetMapping("/{email}")
	public Alumno getUsername(@PathVariable String username) {
		for (Alumno Alumno : ListaAlumnos) {
			if (Alumno.getEmail().equalsIgnoreCase(username)) {
				return Alumno;
			}
		}
		return null;
	}

}
