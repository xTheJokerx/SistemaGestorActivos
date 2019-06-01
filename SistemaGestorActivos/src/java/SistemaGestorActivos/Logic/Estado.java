package SistemaGestorActivos.Logic;
// Generated 31-may-2019 22:51:55 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Estado generated by hbm2java
 */
public class Estado  implements java.io.Serializable {


     private int id;
     private String descripcion;
     private Set<Erazon> erazons = new HashSet<Erazon>(0);
     private Set<Solicitud> solicituds = new HashSet<Solicitud>(0);

    public Estado() {
    }

	
    public Estado(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }
    public Estado(int id, String descripcion, Set<Erazon> erazons, Set<Solicitud> solicituds) {
       this.id = id;
       this.descripcion = descripcion;
       this.erazons = erazons;
       this.solicituds = solicituds;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Set<Erazon> getErazons() {
        return this.erazons;
    }
    
    public void setErazons(Set<Erazon> erazons) {
        this.erazons = erazons;
    }
    public Set<Solicitud> getSolicituds() {
        return this.solicituds;
    }
    
    public void setSolicituds(Set<Solicitud> solicituds) {
        this.solicituds = solicituds;
    }




}


