package org.sofka.ApiCrudTienda.repository;

import org.sofka.ApiCrudTienda.domain.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVendedorRepository extends JpaRepository<Vendedor, Integer> {

}

