package bo.gob.aduana.base.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "manifiesto_item")
@Inheritance(strategy = InheritanceType.JOINED)
public class ManifiestoItem implements Serializable {

	@Id
	@GeneratedValue
	private Long id;

	@NotNull
	@OneToMany(cascade = { CascadeType.ALL }, mappedBy = "aduanasPartidas")
	private List<Aduana> aduanaPartida;

	@NotNull
	@OneToMany(cascade = { CascadeType.ALL }, mappedBy = "aduanasLlegadas")
	private List<Aduana> aduanaDestino;

	@NotNull
	@DecimalMin("0.00000001")
	private Double peso;

	@NotNull
	@DecimalMin("0.00000001")
	private Double cantidadBultos;

	@NotNull
	@OneToMany(cascade = { CascadeType.ALL }, mappedBy = "embalaje")
	private List<Embalaje> embalaje;

	private String descripcion;

	@NotNull
	@OneToMany(cascade = { CascadeType.ALL }, mappedBy = "pais")
	private List<Pais> paisOrigen;

	@NotNull
	@OneToMany(cascade = { CascadeType.ALL }, mappedBy = "consignatario")
	private List<Consignatario> consignatario;

	@NotNull
	@OneToMany(cascade = { CascadeType.ALL }, mappedBy = "estados")
	private List<ManifiestoEstado> manifiestoEstado;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Aduana> getAduanaPartida() {
		return aduanaPartida;
	}

	public void setAduanaPartida(List<Aduana> aduanaPartida) {
		this.aduanaPartida = aduanaPartida;
	}

	public List<Aduana> getAduanaDestino() {
		return aduanaDestino;
	}

	public void setAduanaDestino(List<Aduana> aduanaDestino) {
		this.aduanaDestino = aduanaDestino;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Double getCantidadBultos() {
		return cantidadBultos;
	}

	public void setCantidadBultos(Double cantidadBultos) {
		this.cantidadBultos = cantidadBultos;
	}

	public List<Embalaje> getEmbalaje() {
		return embalaje;
	}

	public void setEmbalaje(List<Embalaje> embalaje) {
		this.embalaje = embalaje;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Pais> getPaisOrigen() {
		return paisOrigen;
	}

	public void setPaisOrigen(List<Pais> paisOrigen) {
		this.paisOrigen = paisOrigen;
	}

	public List<Consignatario> getConsignatario() {
		return consignatario;
	}

	public void setConsignatario(List<Consignatario> consignatario) {
		this.consignatario = consignatario;
	}

}
