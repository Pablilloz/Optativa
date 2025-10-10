package com.ejer3.ejer3.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ejer3.ejer3.modelo.Alumno;
import com.ejer3.ejer3.modelo.Direccion;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

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

	@GetMapping
	public ResponseEntity<List<Alumno>> getClientes() {
		return ResponseEntity.ok(ListaAlumnos);
	}

	@GetMapping("/{email}")
	public ResponseEntity<Alumno> getUsername(@PathVariable String username) {
		for (Alumno Alumno : ListaAlumnos) {
			if (Alumno.getEmail().equalsIgnoreCase(username)) {
				return ResponseEntity.ok(Alumno);
			}
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping("/añadir")
	public ResponseEntity<Alumno> postUsuario(@RequestBody Alumno newAlumno) {
		for (Alumno alumno : ListaAlumnos) {
			if (alumno != newAlumno) {
				ListaAlumnos.add(newAlumno);
				return ResponseEntity.ok(alumno);
			}
		}
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/modificar")
	public ResponseEntity<Alumno> putAlumno(@RequestBody Alumno modif) {
		for (Alumno alumno : ListaAlumnos) {
			if (alumno.getId() == modif.getId()) {
				alumno.setCurso(modif.getCurso());
				alumno.setEdad(modif.getEdad());
				alumno.setEmail(modif.getEmail());
				alumno.setId(modif.getId());
				alumno.setNombre(modif.getNombre());
				alumno.setDireccion(modif.getDireccion());

				return ResponseEntity.ok(modif);
			}
		}
		return ResponseEntity.noContent().build();
	}

	@PatchMapping("/modificar2")
	public ResponseEntity<Alumno> patchCliente(@RequestBody Alumno modif) {
		for (Alumno alumno : ListaAlumnos) {
			if (alumno.getId() == modif.getId()) {
				if (modif.getCurso() != null) {
					alumno.setCurso(modif.getCurso());
				}
				if (modif.getEdad() != 0) {
					alumno.setEdad(modif.getEdad());
				}
				if (modif.getEmail() != null) {
					alumno.setEmail(modif.getEmail());
				}
				if (modif.getNombre() != null) {
					alumno.setNombre(modif.getNombre());
				}
				if (modif.getDireccion() != null) {
					alumno.setDireccion(modif.getDireccion());
				}
				return ResponseEntity.ok(alumno);
			}
		}
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Alumno> deleteCliente(@PathVariable int id) {
		Iterator<Alumno> iterador = ListaAlumnos.iterator();
		while (iterador.hasNext()) {
			Alumno alumno = iterador.next();
			if (alumno.getId() == id) {
				iterador.remove();
				return ResponseEntity.ok(alumno);
			}
		}
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/direcciones")
	public ResponseEntity<List<Direccion>> getDirecciones() {
		List<Direccion> direcciones = new ArrayList<>();
		for (Alumno dato : ListaAlumnos) {
			direcciones.add(dato.getDireccion());
		}
		return ResponseEntity.ok(direcciones);
	}

	@GetMapping("/direcciones/{codigoPostal}")
	public ResponseEntity<List<Direccion>> obtenerDireccionesPorCodigoPostal(@PathVariable String codigo) {
		List<Direccion> direcciones = new ArrayList<>();
		for (Alumno dato : ListaAlumnos) {
			if (dato.getDireccion().getCodigoPostal().equalsIgnoreCase(codigo)) {
				direcciones.add(dato.getDireccion());
				return ResponseEntity.ok(direcciones);
			}
		}
		return ResponseEntity.notFound().build();
	}

	@GetMapping("/direcciones/contar/{ciudad}")
	public ResponseEntity<Integer> ContarAlumnosPorCiudad(@PathVariable String ciudad) {
		int count = 0;
		for (Alumno alumno : ListaAlumnos) {
			if (alumno.getDireccion().getCiudad().equalsIgnoreCase(ciudad)) {
				count++;
			}
			if (count == 0) {
				return ResponseEntity.notFound().build();
			}
		}
		return ResponseEntity.ok(count);
	}
}
