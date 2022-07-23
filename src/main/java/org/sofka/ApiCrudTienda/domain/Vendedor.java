package org.sofka.ApiCrudTienda.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "vendedor")
public class Vendedor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ven_id", nullable = false)
	private Integer id;


	@Column(name = "ven_nombre", nullable = false, length = 100)
	private String venNombre;


	@Column(name = "ven_correo", nullable = false, length = 100)
	private String venCorreo;


	@OneToMany(mappedBy = "vendedor", fetch = FetchType.EAGER)
	@JsonBackReference(value = "factura-vendedor")
	private List<Factura> facturas = new ArrayList<>();




}
