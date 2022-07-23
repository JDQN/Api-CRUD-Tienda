package org.sofka.ApiCrudTienda.repository;

import org.sofka.ApiCrudTienda.domain.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductoRepository extends JpaRepository<Producto, Integer> {

}

