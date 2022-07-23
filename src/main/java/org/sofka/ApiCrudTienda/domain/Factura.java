package org.sofka.ApiCrudTienda.domain;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "factura")
public class Factura {

	@Id
	@Column(name = "fac_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;


	@JsonManagedReference(value = "factura-vendedor")
	@JoinColumn(name = "ven_id_vendedor")
	@ManyToOne(targetEntity = Vendedor.class)
	private Vendedor vendedor;


	@JsonManagedReference(value = "factura-cliente")
	@JoinColumn(name = "cli_id_cliente",unique = true)
	@ManyToOne(targetEntity = Cliente.class)
	private Cliente clienta;


	@JsonManagedReference(value = "factura-detalle")
	@OneToMany(mappedBy = "facIdFactura", fetch = FetchType.EAGER)
	private List<Detalle> detalles = new ArrayList<>();


	@Column(name = "fac_descuento_general")
	private Integer descuento;

}
