package SistemaGestorActivos.Logic;
// Generated 31-may-2019 22:51:55 by Hibernate Tools 4.3.1



/**
 * Usuario generated by hbm2java
 */
public class Usuario  implements java.io.Serializable {


     private String id;
     private Funcionario funcionario;
     private Rol rol;
     private String clave;

    public Usuario() {
    }

	
    public Usuario(Funcionario funcionario, String clave) {
        this.funcionario = funcionario;
        this.clave = clave;
    }
    public Usuario(Funcionario funcionario, Rol rol, String clave) {
       this.funcionario = funcionario;
       this.rol = rol;
       this.clave = clave;
    }
   
    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    public Funcionario getFuncionario() {
        return this.funcionario;
    }
    
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    public Rol getRol() {
        return this.rol;
    }
    
    public void setRol(Rol rol) {
        this.rol = rol;
    }
    public String getClave() {
        return this.clave;
    }
    
    public void setClave(String clave) {
        this.clave = clave;
    }




}


