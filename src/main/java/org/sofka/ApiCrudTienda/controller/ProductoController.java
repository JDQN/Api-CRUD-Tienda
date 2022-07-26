package org.sofka.ApiCrudTienda.controller;
import lombok.extern.slf4j.Slf4j;
import org.sofka.ApiCrudTienda.domain.Producto;
import org.sofka.ApiCrudTienda.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController // Sirve para que sea un controlador REST y no un controlador de vistas
@RequestMapping("/api/v1/producto")
@Slf4j //Sirve para que se imprima en consola el mensaje de error
public class ProductoController {

	@Autowired
	ProductoService productoService;


	/**
	 * El metodo findById es el que se encarga de buscar un producto por su id
	 * @param producto
	 * @return
	 */
	@GetMapping("/api/v1/producto/{id}")
	public Producto findById(@PathVariable("id") Integer id){
		return productoService.findById(id);
	}


	/**
	 * El metodo create es el que se encarga de crear un producto
	 * @param producto
	 * @return
	 */
	@PostMapping("/api/v1/producto")
	public Producto create(@RequestBody Producto producto){
		return productoService.create(producto);
	}


	/**
	 * El metodo update es el que se encarga de actualizar un producto por su id
	 * @param producto
	 * @param id
	 * @return
	 */
	@PutMapping("/api/v1/producto/{id}")
	public Producto update(@RequestBody Producto producto, @PathVariable("id") Integer id){
		return productoService.update(producto, id);
	}


	/**
	 * El metodo delete es el que se encarga de eliminar un producto por su id
	 * @param id
	 * @param nombre
	 */
	@DeleteMapping("/api/v1/producto/{id}")
	public void delete(@PathVariable("id") Integer id, @RequestParam("nombre") String nombre){
		log.error("Nombre {}", nombre);
		productoService.delete(id);
	}
}
