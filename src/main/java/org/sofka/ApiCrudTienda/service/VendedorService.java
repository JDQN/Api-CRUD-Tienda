package org.sofka.ApiCrudTienda.service;

import org.sofka.ApiCrudTienda.domain.Vendedor;
import org.sofka.ApiCrudTienda.service.services.ICrud;
import org.springframework.beans.factory.annotation.Autowired;

public class VendedorService  implements ICrud<Vendedor> {

	@Autowired
	VendedorRepository vendedorRepository;

	@Override
	public Vendedor create(Vendedor vendedor) {
		return vendedorRepository.save(vendedor);
	}

	@Override
	public Vendedor findById(Integer id) {
		return vendedorRepository.findById(id).orElse(new Vendedor());
	}


	@Override
	public Vendedor update(Vendedor vendedor, Integer id) {

		var vendedorAntiguo = vendedorRepository.findById(id).orElse(null);

		if(vendedorAntiguo != null){
			if(vendedorNuevo.getNombre() != null){
				vendedorAntiguo.setNombre(vendedorNuevo.getNombre());
			}
			if(vendedorNuevo.getCortreo() != null){
				vendedorAntiguo.setCortreo(vendedorNuevo.getCortreo());
			}
			return vendedorRepository.save(vendedorAntiguo);
		}
		return null;
	}


	@Override
	public Vendedor delete(Integer id) {

		return null;
	}
}
