package org.sofka.ApiCrudTienda.service;

import org.sofka.ApiCrudTienda.domain.Cliente;
import org.sofka.ApiCrudTienda.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class ClienteService {

	@Autowired
	private IClienteRepository clienteRepository;

	public List<Cliente> getAllClients() {
		return clienteRepository.findAll();
	}

	public Cliente getClient(Integer id){
		return clienteRepository.findById(id).orElse(null);
	}


	public Cliente createCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	public List<Cliente> findByNombre(String nombre) {
		return clienteRepository.findByNombre(nombre);
	}
}

