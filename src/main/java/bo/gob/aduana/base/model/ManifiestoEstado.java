package bo.gob.aduana.base.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "manifiesto_estado")
@Inheritance(strategy = InheritanceType.JOINED)
public class ManifiestoEstado {
	
	@ManyToOne
	@JoinColumn(name="manifiestoItem")
	@NotNull
	private ManifiestoItem manifiestoItem; 

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String estado;

    @NotNull
    private Date fecha;

    @NotNull
    private String usuario;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

	public ManifiestoItem getManifiestoItem() {
		return manifiestoItem;
	}

	public void setManifiestoItem(ManifiestoItem manifiestoItem) {
		this.manifiestoItem = manifiestoItem;
	}
    
}

