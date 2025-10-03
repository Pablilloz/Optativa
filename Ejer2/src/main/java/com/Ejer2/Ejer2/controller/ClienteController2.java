package com.Ejer2.Ejer2.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Ejer2.Ejer2.modelo.Cliente;

@RestController
@RequestMapping("/cliente")
public class ClienteController2 {

	private List<Cliente> clientes = new ArrayList<>();

	Cliente c1 = new Cliente(1, "Saul", "sreyes0104", 1234);
	Cliente c2 = new Cliente(2, "Pablo", "sreyes0104", 1234);
	Cliente c3 = new Cliente(3, "Raul", "sreyes0104", 1234);
	Cliente c4 = new Cliente(4, "Claudia", "sreyes0104", 1234);

	public ClienteController2() {
		// clientes = List.of(c1, c2, c3, c4);
		clientes.add(c1);
		clientes.add(c2);
		clientes.add(c3);
		clientes.add(c4);
	}

	@GetMapping()
	public List<Cliente> getClientes() {
		return clientes;
	}

	@GetMapping("/username")
	public Cliente getUsername(@PathVariable String username) {
		for (Cliente cliente : clientes) {
			if (cliente.getNombre().equalsIgnoreCase(username)) {
				return cliente;
			}
		}
		return null;
	}

	@PostMapping()
	public Cliente postCliente(@RequestBody Cliente cliente) {
		clientes.add(cliente);
		return cliente;
	}

	@PutMapping()
	public Cliente putCliente(@RequestBody Cliente clienteModif) {
		for (Cliente cliente : clientes) {
			if (cliente.getId() == clienteModif.getId()) {
				cliente.setNombre(clienteModif.getNombre());
				cliente.setPassword(clienteModif.getPassword());
				cliente.setUsername(clienteModif.getUsername());

				return clienteModif;
			}
		}
		return null;
	}

	@DeleteMapping("/id")
	public Cliente deleteCliente(@PathVariable int id) {
		Iterator<Cliente> iterador = clientes.iterator();
		while (iterador.hasNext()) {
			Cliente cliente = iterador.next();
			if (cliente.getId() == id) {
				iterador.remove();
				return cliente;
			}
		}

		return null;
	}

	@PatchMapping()
	public Cliente patchCliente(@RequestBody Cliente clienteModif) {
		for (Cliente cliente : clientes) {
			if (cliente.getId() == clienteModif.getId()) {
				if (clienteModif.getNombre() != null) {
					cliente.setNombre(clienteModif.getNombre());
				}
				if (clienteModif.getUsername() != null) {
					cliente.setUsername(clienteModif.getUsername());
				}
				if (clienteModif.getPassword() != null) {
					cliente.setPassword(clienteModif.getPassword());
				}
				return cliente;
			}
		}
		return null;
	}

}
