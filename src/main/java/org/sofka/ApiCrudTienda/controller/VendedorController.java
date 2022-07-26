package org.sofka.ApiCrudTienda.controller;

import lombok.extern.slf4j.Slf4j;
import org.sofka.ApiCrudTienda.domain.Vendedor;
import org.sofka.ApiCrudTienda.service.VendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/vendedor")
@Slf4j
public class VendedorController {

	@Autowired
	VendedorService vendedorService;

	@GetMapping("/{id}")
	public Vendedor findById(@PathVariable("id") Integer id) {
		return vendedorService.findById(id);
	}

	@PostMapping ("")
	public Vendedor create(@RequestBody Vendedor vendedor) {
		return vendedorService.create(vendedor);
	}


	@PutMapping("/{id}")
	public Vendedor update(@RequestBody Vendedor factura, @PathVariable("id") Integer id) {
		return vendedorService.update(factura, id);
	}


	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id,  @RequestParam("nombre") String nombre) {
		log.error("Nombre {}", nombre);
		vendedorService.delete(id);
	}
}
