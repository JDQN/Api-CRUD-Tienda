package org.sofka.ApiCrudTienda.controller;

import lombok.extern.slf4j.Slf4j;
import org.sofka.ApiCrudTienda.controller.Utils.CustomResponse;
import org.sofka.ApiCrudTienda.domain.Cliente;
import org.sofka.ApiCrudTienda.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cliente")
@Slf4j
public class ClienteController {

	@Autowired
	ClienteService clienteService;
	@Autowired
	CustomResponse customResponse;


	/**
	 * PostMapping es utilizado para crear un nuevo cliente.
	 * @param cliente
	 * @return ResponseEntity<Cliente> que es una respuesta de tipo cliente.
	 */
	@PostMapping("/new")
	public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente) {
		return ResponseEntity.ok(clienteService.createCliente(cliente));
	}


	/**
	 * GetMapping es utilizado para obtener todos los clientes.
	 * @return ResponseEntity<List<Cliente>> que es una respuesta de tipo lista de clientes.
	 */
	@GetMapping("/all")
	public ResponseEntity<List<Cliente>> getAllClients() {
		var clientes = clienteService.getAllClients();
		return new ResponseEntity<>(clientes, HttpStatus.NOT_FOUND);
	}



	@GetMapping("/{nombre}")

	public ResponseEntity<CustomResponse> findByNombre(@PathVariable("nombre") String nombre) {
		List<Cliente> clientesEncontrados = clienteService.findByNombre(nombre);
		if (clientesEncontrados.isEmpty()) {
			var message = String.format("No se encontro clientes con el nombre %s", nombre);
			var respuesta = customResponse.fillFields(true, message, new String[]{}, HttpStatus.NOT_FOUND);
			return new ResponseEntity<>(respuesta, HttpStatus.NOT_FOUND);
		}
		var message = String.format("Se encontro %d cliente(s) con el nombre %s", clientesEncontrados.size(), nombre);
		return ResponseEntity.ok(customResponse.fillFields(false, message, clientesEncontrados, HttpStatus.OK));
	}

	@PutMapping("/{id}")
	public Cliente updateCliente(@RequestBody Cliente cliente,@PathVariable("id") Integer id) {
		return clienteService.updateCliente(cliente,id);
	}

	@DeleteMapping("/{id}")
	public void deleteCliente(@PathVariable("id") Integer id) {
		clienteService.deleteCliente(id);
	}

}
