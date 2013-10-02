package bo.gob.aduana.base.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "OPERADOR")
@Inheritance(strategy = InheritanceType.JOINED)
public class ManifiestoCabecera implements Serializable {

	@Id
	@GeneratedValue
	private Long id;
	
	private Date fechaPartida;
	private String placa;
	private String numeroViaje;
	private Date fechaLlegada;
	private String aduanaPartida;
	private String aduanaDestino;
	private Double peso;
	private Double cantidadBultos;

}
