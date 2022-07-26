package org.sofka.ApiCrudTienda.controller;

import lombok.extern.slf4j.Slf4j;
import org.sofka.ApiCrudTienda.domain.Factura;
import org.sofka.ApiCrudTienda.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/factura")
@Slf4j
public class FacturaController {

	@Autowired
	FacturaService facturaService;

	@GetMapping("/{id}")
	public Factura findById(@PathVariable(name = "id") Integer id) {
		return facturaService.findById(id);
	}


	@PostMapping("")
	public Factura create(@RequestBody Factura factura) {
		return facturaService.create(factura);
	}

	@PutMapping("/{id}")
	public Factura update(@RequestBody Factura factura, @PathVariable(name = "id") Integer id) {
		return facturaService.update(factura, id);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable(name = "id") Integer id, @RequestParam("nombre") String nombre) {
		log.error("Nombre {}", nombre);
		facturaService.delete(id);
	}

}
