package SistemaGestorActivos.Logic;

import SistemaGestorActivos.Dao.*;
import java.util.ArrayList;
import java.util.List;

public class Model {

    private ActivoDAO activoDAO;
    private BienDAO bienDAO;
    private CategoriaDAO categoriaDAO;
    private DependenciaDAO dependenciaDAO;
    private ERazonDAO eRazonDAO;
    private EstadoDAO estadoDAO;
    private FuncionarioDAO funcionarioDAO;
    private PuestoDAO puestoDAO;
    private RolDAO rolDAO;
    private SolicitudDAO solicitudDAO;
    private UsuarioDAO usuarioDAO;

    private static Model uniqueInstance;

    public static Model instance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Model();
        }
        return uniqueInstance;
    }

    public Model() {
        activoDAO = new ActivoDAO();
        bienDAO = new BienDAO();
        categoriaDAO = new CategoriaDAO();
        dependenciaDAO = new DependenciaDAO();
        eRazonDAO = new ERazonDAO();
        estadoDAO = new EstadoDAO();
        funcionarioDAO = new FuncionarioDAO();
        puestoDAO = new PuestoDAO();
        rolDAO = new RolDAO();
        solicitudDAO = new SolicitudDAO();
        usuarioDAO = new UsuarioDAO();
    }

    public ActivoDAO getActivoDAO() {
        return activoDAO;
    }

    public BienDAO getBienDAO() {
        return bienDAO;
    }

    public CategoriaDAO getCategoriaDAO() {
        return categoriaDAO;
    }

    public DependenciaDAO getDependenciaDAO() {
        return dependenciaDAO;
    }

    public ERazonDAO geteRazonDAO() {
        return eRazonDAO;
    }

    public EstadoDAO getEstadoDAO() {
        return estadoDAO;
    }

    public FuncionarioDAO getFuncionarioDAO() {
        return funcionarioDAO;
    }

    public PuestoDAO getPuestoDAO() {
        return puestoDAO;
    }

    public RolDAO getRolDAO() {
        return rolDAO;
    }

    public SolicitudDAO getSolicitudDAO() {
        return solicitudDAO;
    }

    public UsuarioDAO getUsuarioDAO() {
        return usuarioDAO;
    }

    public String obtenerFuncionarioActual(Usuario user) {
        String f = "";
        f = this.getUsuarioDAO().busquedaNombre(user.getId());
        return f;
    }

    public String obtenerRolActual(Usuario user) {
        String rol = "";
        rol = this.getUsuarioDAO().busquedaRol(user.getId());
        return rol;
    }

    public String obtenerDependenciaActual(Usuario user) {
        String dep = "";
        dep = this.getUsuarioDAO().busquedaDependencia(user.getId());
        return dep;
    }

    public List<Solicitud> obtenerTotalSolicitudes(Usuario user) {
        List<Solicitud> sols = new ArrayList<>();
        sols = this.getUsuarioDAO().getSolicitudes(user.getId());
        return sols;
    }

    public List<Solicitud> obtenerTotalSolicitudes() {
        List<Solicitud> sols = new ArrayList<>();
        sols = this.getSolicitudDAO().getSolicitudes();
        return sols;
    }

    public List<Solicitud> obtenerSolicitudesPorVerificar() {
        List<Solicitud> sols = new ArrayList<>();
        sols = this.getSolicitudDAO().getSolicitudesPorVerificar();
        return sols;
    }

    public List<Solicitud> obtenerTotalSolicitudesXRegistrador(String idReg) {
        List<Solicitud> sols = new ArrayList<>();
        sols = this.getSolicitudDAO().getSolicitudesPorRegistrador(idReg);
        return sols;
    }

    public List<Funcionario> obtenerRegistradores() {
        List<Funcionario> funs = new ArrayList<>();
        funs = this.getFuncionarioDAO().getRegistradores();
        return funs;
    }

    public List<Solicitud> obtenerSolicitudesXComprobante(Usuario user, String comprobante) {
        List<Solicitud> sols = new ArrayList<>();
        sols = this.getUsuarioDAO().getSolicitudesPorComprobante(user.getId(), comprobante);
        return sols;
    }

    public List<Solicitud> obtenerSolicitudesXComprobante(String comprobante) {
        List<Solicitud> sols = new ArrayList<>();
        sols = this.getSolicitudDAO().getSolicitudesPorComprobante(comprobante);
        return sols;
    }

    public List<Solicitud> obtenerSolicitudesXComprobanteJefe(String comprobante) {
        List<Solicitud> sols = new ArrayList<>();
        sols = this.getSolicitudDAO().getSolicitudesPorComprobanteJefe(comprobante);
        return sols;
    }

    public Dependencia obtenerDependenciaPorUsuario(String id) {
        Dependencia dependencia = null;
        dependencia = this.getUsuarioDAO().busquedaDependenciaPorUsuario(id);
        return dependencia;
    }

    public Estado obtenerEstado(int id) {
        Estado estado = null;
        estado = this.getEstadoDAO().findById(id);
        return estado;
    }

    public List<Bien> obtenerBienesPorSolicitud(int dependencia, int solicitud) {
        return this.getBienDAO().getBienesBySolicitud(dependencia, solicitud);
    }

    public List<Bien> obtenerBienesPorSolicitud(int solicitud) {
        return this.getBienDAO().getBienesBySolicitud(solicitud);
    }

    public List<Categoria> obtenerCategorias() {
        return this.getCategoriaDAO().findAll();
    }

    public Solicitud obtenerSolicitudCompleta(int idSolicitud) {
        Solicitud solicitud = new Solicitud();
        List<Solicitud> lista = this.getSolicitudDAO().getSolicitud(idSolicitud);
        solicitud = lista.get(0);
        return solicitud;
    }

    public void AprobarSolicitud(int solicitud) {
        this.getSolicitudDAO().AprobarSolicitud(solicitud);
    }

    public void RechazarSolicitud(int solicitud) {
        this.getSolicitudDAO().RechazarSolicitud(solicitud);
    }

    public void asignacionDeRegistrador(int idSolicitud, String idRegistrador) {
        this.getSolicitudDAO().asignacionDeRegistrador(idSolicitud, idRegistrador);
    }

    public void registroDeActivo(int idBien, String idCategoria) {
        this.getSolicitudDAO().registroDeActivo(idBien, idCategoria);
    }

    public void agregarCategoria(Categoria categoria) {
        this.getCategoriaDAO().save(categoria);
    }

    public Categoria obtenerCategoria(int id) {
        return this.getCategoriaDAO().findById(id);
    }

    public void eliminarCategoria(int id) {
        this.getCategoriaDAO().delete(id);
    }

    public List<Categoria> obtenerCategorias(String descripcion) {
        return this.getCategoriaDAO().getCategoriasPorDescripcion(descripcion);
    }

    public void actualizarCategoria(Categoria categoria) {
        this.getCategoriaDAO().merge(categoria);
    }
    
    public  void agregarPuesto(Puesto puesto) {
        this.getPuestoDAO().save(puesto);
    }
    
    public Puesto ObtenerPuesto(int id){
        return this.getPuestoDAO().findById(id);
    }
    
    public void eliminarPuesto(int id){
        this.getPuestoDAO().delete(id);
    }
    
    public void actualizarPuesto(Puesto puesto){
        this.getPuestoDAO().merge(puesto);
    }

    public List<Puesto> ObtenerPuestos(String descripcion){
        return this.getPuestoDAO().getPuestoPorDescripcion(descripcion);
    }

    public  void agregarDependencia(Dependencia dependencia) {
        this.getDependenciaDAO().save(dependencia);
    }
    
    public Dependencia ObtenerDependencia(int id){
        return this.getDependenciaDAO().findById(id);
    }
    
    public void actualizarDependencia(Dependencia dependencia){
        this.getDependenciaDAO().merge(dependencia);
    }

    public List<Dependencia> ObtenerDependencias(String nombre){
        return this.getDependenciaDAO().getPuestoPorNombre(nombre);
    }
    public List<Dependencia> ObtenerDependenciasId(int id){
        return this.getDependenciaDAO().find(id);
    }
    
    public void eliminarDependencia(int id){
        this.getDependenciaDAO().delete(id);
    }
    
    public void actualizarFuncionario(Funcionario funcionario){
        this.getFuncionarioDAO().merge(funcionario);
    }

    public List<Funcionario> ObtenerFuncionario(String nombre){
        return this.getFuncionarioDAO().getFuncionarioPorNombre(nombre);
    }
    
    public List<Funcionario> ObtenerTodoFuncionario(){
        return this.getFuncionarioDAO().getTodoFuncionario();
    }
    
    public List<Funcionario> ObtenerFuncionariosId(int id){
        return this.getFuncionarioDAO().findFuncionario(id);
    }
    
    public  void agregarFuncionario(Funcionario funcionario) {
        this.getFuncionarioDAO().save(funcionario);
    }
    
    public Funcionario ObtenerFuncionario(int id){
        return this.getFuncionarioDAO().findByIdFuncionario(id);
    }
    
    public void eliminarFuncionario(int id){
        this.getFuncionarioDAO().deleteFuncionario(id);
    }
    
    
}
