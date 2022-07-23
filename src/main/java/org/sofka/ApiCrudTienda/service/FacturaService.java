package org.sofka.ApiCrudTienda.service;

import org.sofka.ApiCrudTienda.domain.Factura;
import org.sofka.ApiCrudTienda.repository.IFacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class FacturaService {

	@Autowired
	private IFacturaRepository facturaRepository;

	public Factura findById(Integer id){
		return facturaRepository.findById(id).orElse(null);
	}
}
