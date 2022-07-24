package org.sofka.ApiCrudTienda.controller;

import lombok.extern.slf4j.Slf4j;
import org.sofka.ApiCrudTienda.service.ClienteService;
import org.sofka.ApiCrudTienda.domain.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
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
public class ClienteController<Cliente> {

	@Autowired
	ClienteService clienteService;

	/**
	 * El metodo getClients() retorna una lista de clientes
	 * @return el clienteService
	 */
	@GetMapping("/")
	public List<Cliente> getClientes() {
		return (List<Cliente>) clienteService.getClients();
	}

	/**
	 * El metodo getCliente(@PathVariable(name = "id") Integer id) retorna un cliente
	 * @param id el id del cliente
	 * @return el clienteService
	 */
	@GetMapping("/{id}")
	public Cliente getCliente(@PathVariable(name = "id") Integer id) {
		return (Cliente) clienteService.getClient(id);
	}

	/**
	 * El metodo getClientByCorreo(@PathVariable(value = "correo") String correo,
	 * @PathVariable(value = "nombre") String nombre) retorna un cliente
	 * @param correo el correo del cliente
	 * @param nombre el nombre del cliente
	 * @return el clienteService
	 */
	@GetMapping("/{correo}/{nombre}")
	public void getClienteByCorreo(@PathVariable(value="correo") String correo,
																 @PathVariable(value="nombre") String nombre){
		System.out.println("Correo:" +correo+ "Nombre:" +nombre);
		//        clientService.getClientByCorreo(nombre);
		//        ?key=value
		//        &key=value
	}


	/**
	 * El metodo newClient(@RequestBody String cliente) crea un nuevo cliente
	 * @param cliente el cliente a crear
	 * @return el clienteService
	 */
	@PostMapping(value="/new", consumes="application/json")
	public void newCliente(@RequestBody String cliente){
		log.info("Nuevo cliente:" +cliente);
	}
}
