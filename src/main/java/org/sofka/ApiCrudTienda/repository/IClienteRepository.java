package org.sofka.ApiCrudTienda.repository;


import org.sofka.ApiCrudTienda.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IClienteRepository extends JpaRepository<Cliente, Integer> {

	<Cliente> List<Cliente> findByNombre(String nombre);
}
