package pe.gob.mincetur.webdestinosturisticos.Beans;

import java.util.List;

public class Detalle {
    
    private int codigo;
    private String departamento;
    private String nombre;
    private List<DestinoFoto> imagenes;
    private String descripcion;
    private List<DestinoDetalle> servicios;

    public Detalle(int codigo, String departamento, String nombre, String descripcion) {
        this.codigo = codigo;
        this.departamento = departamento;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Detalle(int codigo, String departamento, String nombre, List<DestinoFoto> imagenes, String descripcion, List<DestinoDetalle> servicios) {
        this.codigo = codigo;
        this.departamento = departamento;
        this.nombre = nombre;
        this.imagenes = imagenes;
        this.descripcion = descripcion;
        this.servicios = servicios;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<DestinoFoto> getImagenes() {
        return imagenes;
    }

    public void setImagenes(List<DestinoFoto> imagenes) {
        this.imagenes = imagenes;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<DestinoDetalle> getServicios() {
        return servicios;
    }

    public void setServicios(List<DestinoDetalle> servicios) {
        this.servicios = servicios;
    }
    
    

}
