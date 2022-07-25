package org.sofka.ApiCrudTienda.controller;

import org.sofka.ApiCrudTienda.domain.Factura;
import org.sofka.ApiCrudTienda.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/factura")
public class FacturaController {

	@Autowired
	FacturaService facturaService;

	@GetMapping("/api/v1/{id}")
	public Factura findById(@PathVariable(name = "id") Integer id) {
		return facturaService.findById(id);
	}
}
