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

	public Cliente createCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	public List<Cliente> findByNombre(String nombre) {
		return clienteRepository.findByNombre(nombre);
	}

	public Cliente updateCliente(Cliente clienteNuevo, Integer id) {

		var clienteAntiguo = clienteRepository.findById(id).orElse(null);

		if(clienteAntiguo != null) {

			if(clienteNuevo.getNombre() != null) {
				clienteAntiguo.setNombre(clienteNuevo.getNombre());
			}
			if(clienteNuevo.getTelefono() != null) {
				clienteAntiguo.setTelefono(clienteNuevo.getTelefono());
			}
			if(clienteNuevo.getCorreo() != null) {
				clienteAntiguo.setCorreo(clienteNuevo.getCorreo());
			}
			clienteRepository.save(clienteAntiguo);
		}
		return clienteAntiguo;
	}

	public void deleteCliente(Integer id) {
		clienteRepository.deleteById(id);
	}

}

