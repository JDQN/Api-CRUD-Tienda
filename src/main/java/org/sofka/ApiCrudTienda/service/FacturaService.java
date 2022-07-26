package org.sofka.ApiCrudTienda.service;

import org.sofka.ApiCrudTienda.domain.Factura;
import org.sofka.ApiCrudTienda.repository.IFacturaRepository;
import org.sofka.ApiCrudTienda.service.interfaces.ICrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class FacturaService implements ICrud<Factura> {

	@Autowired
	IFacturaRepository facturaRepository;

	@Override
	public Factura create(Factura factura) {
		return facturaRepository.save(factura);
	}

	@Override
	public Factura findById(Integer id){
		return facturaRepository.findById(id).orElse(null);
	}

	@Override
	public Factura update(Factura factura, Integer id) {
		var facturaAntigua = facturaRepository.findById(id).orElse(null);
		return  facturaAntigua;
	}

	@Override
	public void delete(Integer id) {
		facturaRepository.deleteById(id);
	}

}
