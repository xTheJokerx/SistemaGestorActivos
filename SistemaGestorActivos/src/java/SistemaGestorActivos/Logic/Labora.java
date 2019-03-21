package SistemaGestorActivos.Logic;
// Generated 19-mar-2019 19:56:13 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Labora generated by hbm2java
 */
public class Labora  implements java.io.Serializable {


     private Integer codigoLab;
     private Dependencia dependencia;
     private Funcionario funcionario;
     private String puesto;
     private Set<Activo> activos = new HashSet<Activo>(0);

    public Labora() {
    }

	
    public Labora(String puesto) {
        this.puesto = puesto;
    }
    public Labora(Dependencia dependencia, Funcionario funcionario, String puesto, Set<Activo> activos) {
       this.dependencia = dependencia;
       this.funcionario = funcionario;
       this.puesto = puesto;
       this.activos = activos;
    }
   
    public Integer getCodigoLab() {
        return this.codigoLab;
    }
    
    public void setCodigoLab(Integer codigoLab) {
        this.codigoLab = codigoLab;
    }
    public Dependencia getDependencia() {
        return this.dependencia;
    }
    
    public void setDependencia(Dependencia dependencia) {
        this.dependencia = dependencia;
    }
    public Funcionario getFuncionario() {
        return this.funcionario;
    }
    
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    public String getPuesto() {
        return this.puesto;
    }
    
    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
    public Set<Activo> getActivos() {
        return this.activos;
    }
    
    public void setActivos(Set<Activo> activos) {
        this.activos = activos;
    }




}


