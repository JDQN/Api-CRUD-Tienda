package org.sofka.ApiCrudTienda.repository;

import org.sofka.ApiCrudTienda.domain.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFacturaRepository extends JpaRepository<Factura, Integer> {

}

