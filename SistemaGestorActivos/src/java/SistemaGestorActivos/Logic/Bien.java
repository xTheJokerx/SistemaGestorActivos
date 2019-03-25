package SistemaGestorActivos.Logic;
// Generated 24-mar-2019 18:06:35 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Bien generated by hbm2java
 */
public class Bien  implements java.io.Serializable {


     private Integer id;
     private Solicitud solicitud;
     private String descripcion;
     private String marca;
     private String modelo;
     private float precio;
     private int cantidad;
     private Set<Activo> activos = new HashSet<Activo>(0);

    public Bien() {
    }

	
    public Bien(String descripcion, String marca, String modelo, float precio, int cantidad) {
        this.descripcion = descripcion;
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        this.cantidad = cantidad;
    }
    public Bien(Solicitud solicitud, String descripcion, String marca, String modelo, float precio, int cantidad, Set<Activo> activos) {
       this.solicitud = solicitud;
       this.descripcion = descripcion;
       this.marca = marca;
       this.modelo = modelo;
       this.precio = precio;
       this.cantidad = cantidad;
       this.activos = activos;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Solicitud getSolicitud() {
        return this.solicitud;
    }
    
    public void setSolicitud(Solicitud solicitud) {
        this.solicitud = solicitud;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getMarca() {
        return this.marca;
    }
    
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getModelo() {
        return this.modelo;
    }
    
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public float getPrecio() {
        return this.precio;
    }
    
    public void setPrecio(float precio) {
        this.precio = precio;
    }
    public int getCantidad() {
        return this.cantidad;
    }
    
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public Set<Activo> getActivos() {
        return this.activos;
    }
    
    public void setActivos(Set<Activo> activos) {
        this.activos = activos;
    }




}


