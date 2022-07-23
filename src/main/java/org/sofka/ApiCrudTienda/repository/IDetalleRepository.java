package org.sofka.ApiCrudTienda.repository;

import org.sofka.ApiCrudTienda.domain.Detalle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDetalleRepository extends JpaRepository<Detalle, Integer> {

}

