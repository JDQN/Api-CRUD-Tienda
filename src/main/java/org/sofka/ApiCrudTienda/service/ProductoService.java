package org.sofka.ApiCrudTienda.service;

import org.sofka.ApiCrudTienda.domain.Producto;
import org.sofka.ApiCrudTienda.repository.IProductoRepository;
import org.sofka.ApiCrudTienda.service.interfaces.ICrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //@Service sirve para indicar que es un servicio que se va a utilizar en el proyecto
public class ProductoService implements ICrud<Producto> {

	@Autowired //Con el @Autowired se indica que se va a inyectar el objeto que se encuentra en el repositorio.
	IProductoRepository productoRepository; //IProductoRepository sirve para indicar que se va a inyectar el objeto que se encuentra en el repositorio.

	/**
	 * Aqui tenemos el metodo que crea un nuevo producto
	 * @param producto Nuevo producto a crear
	 * @return el nuevo producto creado
	 */
	@Override //@Override sirve para indicar que es un metodo que se va a sobreescribir en la clase padre.
	public Producto create(Producto producto) {
		return productoRepository.save(producto);
	}


	/**
	 * Aqui tenemos el metodo que busca un producto por su id
	 * @param id del producto a buscar
	 * @return el producto encontrado
	 */
	@Override
	public Producto findById(Integer id) {
		return productoRepository.findById(id).orElse(new Producto());
	}


	/**
	 * Aqui tenemos el metodo que actualiza un producto
	 * @param productoNuevo nuevo producto a actualizar
	 * @param id del producto a actualizar
	 * @return el producto actualizado
	 */
	@Override
	public Producto update(Producto productoNuevo, Integer id) {
		var productoAntiguo = productoRepository.findById(id).orElse(null);

		if(productoAntiguo != null){
			if(productoNuevo.getProdNombre() != null){
				productoAntiguo.setProdNombre(productoNuevo.getProdNombre());
			}
			if(productoNuevo.getProdValor() != null){
				productoAntiguo.setProdValor(productoNuevo.getProdValor());
			}
			productoRepository.save(productoAntiguo);
		}
		return productoAntiguo;
	}


	/**
	 * Aqui tenemos el metodo que elimina un producto
	 * @param id del producto a eliminar
	 */
	@Override
	public void delete(Integer id) {
		productoRepository.deleteById(id);
	}
}