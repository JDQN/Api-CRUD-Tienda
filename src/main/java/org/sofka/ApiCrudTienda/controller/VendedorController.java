package org.sofka.ApiCrudTienda.controller;

import org.sofka.ApiCrudTienda.domain.Vendedor;
import org.sofka.ApiCrudTienda.service.VendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/vendedor")
public class VendedorController {

	@Autowired
	VendedorService vendedorService;

	@GetMapping("/api/v1/{id}")
	public Vendedor findById(@PathVariable("id") Integer id) {
		return vendedorService.findById(id);
	}

	@PostMapping ("/api/v1")
	public Vendedor create(@RequestBody Vendedor vendedor) {
		return vendedorService.create(vendedor);
	}


	@PutMapping("/api/v1/{id}")
	public Vendedor update(@RequestBody Vendedor factura, @PathVariable("id") Integer id) {
		return vendedorService.update(factura, id);
	}


	@DeleteMapping("/api/v1/{id}")
	public Vendedor delete(@PathVariable("id") Integer id) {
		return vendedorService.delete(id);
	}
}
