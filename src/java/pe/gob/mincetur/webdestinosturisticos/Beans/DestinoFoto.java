package pe.gob.mincetur.webdestinosturisticos.Beans;

public class DestinoFoto {
    
    private int codigo;
    private String nombre;
    private String descripcion;
    private String rutaImagen;

    public DestinoFoto(int codigo, String nombre, String descripcion, String rutaImagen) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.rutaImagen = rutaImagen;
    }

    public DestinoFoto(int codigo, String rutaImagen) {
        this.codigo = codigo;
        this.rutaImagen = rutaImagen;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }
    
    
    
}
