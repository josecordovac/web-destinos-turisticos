package pe.gob.mincetur.webdestinosturisticos.Beans;

public class DestinoDetalle {

    private int codigo;
    private TipoDetalle tipo;
    private String nombre;
    private String descripcion;

    public DestinoDetalle(int codigo, TipoDetalle tipo, String nombre, String descripcion) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public DestinoDetalle(int codigo, String nombre, String descripcion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    
    

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public TipoDetalle getTipo() {
        return tipo;
    }

    public void setTipo(TipoDetalle tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
}
