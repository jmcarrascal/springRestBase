package bo.gob.aduana.base.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import org.codehaus.jackson.annotate.JsonIgnore;

import bo.gob.aduana.base.util.DateUtil;

@Entity
@Table(name = "manifiesto_cabecera")
@Inheritance(strategy = InheritanceType.JOINED)
public class ManifiestoCabecera implements Serializable {

   

	@Id
    @GeneratedValue
    private Long id;

    @NotNull
    private Timestamp fechaPartida;

    @OneToOne
	@NotNull
    private Placa placa;

    @Transient
    private String formatFechaPartida;
    
    @Transient
    private String formatFechaLlegada;

    @NotNull
    private String numeroViaje;

    private Timestamp fechaLlegada;

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

   
    @JsonIgnore
    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "manifiestoCabecera")
    private List<ManifiestoItem> manifiestoItem;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

   
   

    public String getNumeroViaje() {
        return numeroViaje;
    }

    public void setNumeroViaje(String numeroViaje) {
        this.numeroViaje = numeroViaje;
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

  

    public List<ManifiestoItem> getManifiestoItem() {
		return manifiestoItem;
	}

	public void setManifiestoItem(List<ManifiestoItem> manifiestoItem) {
		this.manifiestoItem = manifiestoItem;
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
    
    public Placa getPlaca() {
		return placa;
	}

	public void setPlaca(Placa placa) {
		this.placa = placa;
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

	public Timestamp getFechaPartida() {
		return fechaPartida;
	}

	public void setFechaPartida(Timestamp fechaPartida) {
		this.fechaPartida = fechaPartida;
	}

	public Timestamp getFechaLlegada() {
		return fechaLlegada;
	}

	public void setFechaLlegada(Timestamp fechaLlegada) {
		
		this.fechaLlegada = fechaLlegada;
	}

	public String getFormatFechaPartida() {
		formatFechaPartida = DateUtil.getFormattedDate(fechaPartida);
		return formatFechaPartida;
	}

	public void setFormatFechaPartida(String formatFechaPartida) {
		fechaPartida = DateUtil.composeDate(formatFechaPartida);
		setFechaPartida(fechaPartida);
		this.formatFechaPartida = formatFechaPartida;
	}

	public String getFormatFechaLlegada() {
		formatFechaLlegada = DateUtil.getFormattedDate(fechaLlegada);
		return formatFechaLlegada;
	}

	public void setFormatFechaLlegada(String formatFechaLlegada) {
		fechaLlegada = DateUtil.composeDate(formatFechaLlegada);
		setFechaLlegada(fechaLlegada);
		this.formatFechaLlegada = formatFechaLlegada;
	}
	
	
}
