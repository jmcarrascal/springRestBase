package bo.gob.aduana.base.model;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "manifiesto_item")
@Inheritance(strategy = InheritanceType.JOINED)
public class ManifiestoItem implements Serializable {
	
	@ManyToOne
	@JoinColumn(name="manifiestoCabecera")
	@NotNull
	private ManifiestoCabecera manifiestoCabecera; 

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
	@JoinColumn(name="aduanaPartida")
	@NotNull
    private Aduana aduanaPartida;

    @ManyToOne
	@JoinColumn(name="aduanaDestino")
	@NotNull
    private Aduana aduanaDestino;

    @NotNull
    @DecimalMin("0.00000001")
    private Double peso;

    @NotNull
    @DecimalMin("0.00000001")
    private Double cantidadBultos;

    @ManyToOne
   	@JoinColumn(name="embalaje")
   	@NotNull
    private Embalaje embalaje;

    private String descripcion;

    @NotNull
    @OneToOne
    private Pais paisOrigen;

    @NotNull
    @OneToOne
    private Consignatario consignatario;

    @NotNull
    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "manifiestoItem")
    private List<ManifiestoEstado> manifiestoEstado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

  

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

	public ManifiestoCabecera getManifiestoCabecera() {
		return manifiestoCabecera;
	}

	public void setManifiestoCabecera(ManifiestoCabecera manifiestoCabecera) {
		this.manifiestoCabecera = manifiestoCabecera;
	}

	public Aduana getAduanaPartida() {
		return aduanaPartida;
	}

	public void setAduanaPartida(Aduana aduanaPartida) {
		this.aduanaPartida = aduanaPartida;
	}

	public Aduana getAduanaDestino() {
		return aduanaDestino;
	}

	public void setAduanaDestino(Aduana aduanaDestino) {
		this.aduanaDestino = aduanaDestino;
	}

	public Embalaje getEmbalaje() {
		return embalaje;
	}

	public void setEmbalaje(Embalaje embalaje) {
		this.embalaje = embalaje;
	}

	public Pais getPaisOrigen() {
		return paisOrigen;
	}

	public void setPaisOrigen(Pais paisOrigen) {
		this.paisOrigen = paisOrigen;
	}

	public Consignatario getConsignatario() {
		return consignatario;
	}

	public void setConsignatario(Consignatario consignatario) {
		this.consignatario = consignatario;
	}

	public List<ManifiestoEstado> getManifiestoEstado() {
		return manifiestoEstado;
	}

	public void setManifiestoEstado(List<ManifiestoEstado> manifiestoEstado) {
		this.manifiestoEstado = manifiestoEstado;
	}

   
}
