package pe.gob.mincetur.portaldestinosturisticos.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "destinos")
public class Destino {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "nombre")
    private String name;

    @Column(name = "descripcion", columnDefinition="TEXT")
    private String descripcion;

    @Column(name = "imageUrl")
    private String imageUrl;

    @Column(name = "departamento")
    private String departamento;

    @Column(name = "ubicacion")
    private String location;

    @Column(name = "transporte")
    private String transport;

    public Destino() {
        super();
    }

    public Destino(long id, String name, String departamento, String location, String transport) {
        this.id = id;
        this.name = name;
        this.departamento = departamento;
        this.location = location;
        this.transport = transport;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTransport() {
        return transport;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}
