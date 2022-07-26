package org.sofka.ApiCrudTienda.controller;

import lombok.extern.slf4j.Slf4j;
import org.sofka.ApiCrudTienda.controller.Utils.RespuestasPersonalizadas;
import org.sofka.ApiCrudTienda.domain.Cliente;
import org.sofka.ApiCrudTienda.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/cliente")
@Slf4j
public class ClienteController {

	@Autowired
	ClienteService clienteService;
	@Autowired
	RespuestasPersonalizadas respuestasPersonalizadas;

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
	public ResponseEntity<RespuestasPersonalizadas> findByNombre(@PathVariable("nombre") String nombre) {
		List<Cliente> clientesEncontrados = clienteService.findByNombre(nombre);

		if (clientesEncontrados.isEmpty()) {
			var message = String.format("No se encontro clientes con el nombre %s", nombre);
			var respuesta = RespuestasPersonalizadas.fillFields(true, message, new String[]{},
					HttpStatus.NOT_FOUND);

			return new ResponseEntity<>(respuesta, HttpStatus.NOT_FOUND);
		}

		var message = String.format("Se encontro %d cliente(s) con el nombre %s",
				clientesEncontrados.size(), nombre);

		return ResponseEntity.ok(
					RespuestasPersonalizadas.fillFields(false, message, clientesEncontrados, HttpStatus.OK));
	}
}
