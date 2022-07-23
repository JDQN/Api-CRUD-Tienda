package org.sofka.ApiCrudTienda.repository;


import org.sofka.ApiCrudTienda.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClienteRepository extends JpaRepository<Cliente, Integer> {

}
