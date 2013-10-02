package bo.gob.aduana.base.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "aduana")
@Inheritance(strategy = InheritanceType.JOINED)
public class Aduana {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    @NotNull
    private String codigo;

    @NotNull
    private String descripcion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
