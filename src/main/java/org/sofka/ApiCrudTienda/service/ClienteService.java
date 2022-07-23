package org.sofka.ApiCrudTienda.service;

import org.sofka.ApiCrudTienda.domain.Cliente;
import org.sofka.ApiCrudTienda.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class ClienteService {

	@Autowired
	IClienteRepository clienteRepository;

	public List<Cliente> getClients() {
		return clienteRepository.findAll();
	}

	public Cliente getClient(Integer id){
		return clienteRepository.findById(id).orElse(null);
	}

	/*public void calcularIva(Cliente cliente){
		cliente.setIva(cliente.getIva()*0.16);
	}*/
}

