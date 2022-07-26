package org.sofka.ApiCrudTienda.service;

import org.sofka.ApiCrudTienda.domain.Vendedor;
import org.sofka.ApiCrudTienda.repository.IVendedorRepository;
import org.sofka.ApiCrudTienda.service.interfaces.ICrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendedorService  implements ICrud<Vendedor> {

	@Autowired
	IVendedorRepository vendedorRepository;


	@Override
	public Vendedor create(Vendedor vendedor) {
		return vendedorRepository.save(vendedor);
	}


	@Override
	public Vendedor findById(Integer id) {
		return vendedorRepository.findById(id).orElse(new Vendedor());
	}


	@Override
	public Vendedor update(Vendedor vendedorNuevo, Integer id) {
		var vendedorAntiguo = vendedorRepository.findById(id).orElse(null);

		if (vendedorAntiguo != null) {
			if (vendedorNuevo.getVenNombre() != null) {
				vendedorAntiguo.setVenNombre(vendedorNuevo.getVenNombre());
			}
			if (vendedorNuevo.getVenCorreo() != null) {
				vendedorAntiguo.setVenCorreo(vendedorNuevo.getVenCorreo());
			}
			vendedorRepository.save(vendedorAntiguo);
		}
		return vendedorAntiguo;
	}


	@Override
	public void delete(Integer id) {
		vendedorRepository.deleteById(id);
	}
}
