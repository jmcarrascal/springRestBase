package bo.gob.aduana.base.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "manifiesto_cabecera")
@Inheritance(strategy = InheritanceType.JOINED)
public class ManifiestoCabecera implements Serializable {

	@Id
	@GeneratedValue
	private Long id;

	@NotNull
	private Date fechaPartida;

	@NotNull
	@OneToMany(cascade = { CascadeType.ALL }, mappedBy = "placas")
	private List<Placa> placa;

	@NotNull
	private String numeroViaje;

	private Date fechaLlegada;

	@NotNull
	@OneToMany(cascade = { CascadeType.ALL }, mappedBy = "aduanasPartida")
	private List<Aduana> aduanaPartida;

	@NotNull
	@OneToMany(cascade = { CascadeType.ALL }, mappedBy = "aduanasLlegada")
	private List<Aduana> aduanaDestino;

	@NotNull
	@DecimalMin("0.00000001")
	private Double peso;

	@NotNull
	@DecimalMin("0.00000001")
	private Double cantidadBultos;

	@NotNull
	@OneToMany(cascade = { CascadeType.ALL }, mappedBy = "items")
	private List<ManifiestoCabecera> manifiestoCabecera;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFechaPartida() {
		return fechaPartida;
	}

	public void setFechaPartida(Date fechaPartida) {
		this.fechaPartida = fechaPartida;
	}

	public List<Placa> getPlaca() {
		return placa;
	}

	public void setPlaca(List<Placa> placa) {
		this.placa = placa;
	}

	public String getNumeroViaje() {
		return numeroViaje;
	}

	public void setNumeroViaje(String numeroViaje) {
		this.numeroViaje = numeroViaje;
	}

	public Date getFechaLlegada() {
		return fechaLlegada;
	}

	public void setFechaLlegada(Date fechaLlegada) {
		this.fechaLlegada = fechaLlegada;
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

	public List<ManifiestoCabecera> getManifiestoCabecera() {
		return manifiestoCabecera;
	}

	public void setManifiestoCabecera(
			List<ManifiestoCabecera> manifiestoCabecera) {
		this.manifiestoCabecera = manifiestoCabecera;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((aduanaPartida == null) ? 0 : aduanaPartida.hashCode());
		result = prime * result
				+ ((fechaPartida == null) ? 0 : fechaPartida.hashCode());
		result = prime * result
				+ ((numeroViaje == null) ? 0 : numeroViaje.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ManifiestoCabecera other = (ManifiestoCabecera) obj;
		if (aduanaPartida == null) {
			if (other.aduanaPartida != null)
				return false;
		} else if (!aduanaPartida.equals(other.aduanaPartida))
			return false;
		if (fechaPartida == null) {
			if (other.fechaPartida != null)
				return false;
		} else if (!fechaPartida.equals(other.fechaPartida))
			return false;
		if (numeroViaje == null) {
			if (other.numeroViaje != null)
				return false;
		} else if (!numeroViaje.equals(other.numeroViaje))
			return false;
		return true;
	}
}
