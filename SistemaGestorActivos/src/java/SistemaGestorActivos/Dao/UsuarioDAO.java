package SistemaGestorActivos.Dao;

import SistemaGestorActivos.Logic.Estado;
import SistemaGestorActivos.Logic.Solicitud;
import java.util.List;
import org.hibernate.HibernateException;
import SistemaGestorActivos.Logic.Usuario;
import SistemaGestorActivos.Utils.HibernateUtil;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioDAO extends HibernateUtil implements IBaseDao<Usuario, String> {

    @Override
    public void save(Usuario o) {
        try {
            iniciaOperacion();
            getSesion().save(o);
            getTransc().commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            getSesion().close();
        }
    }

    @Override
    public Usuario merge(Usuario o) throws HibernateException {
        try {
            iniciaOperacion();
            o = (Usuario) getSesion().merge(o);
            getTransc().commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            getSesion().close();
        }
        return o;
    }

    @Override
    public void delete(Usuario o) {
        try {
            iniciaOperacion();
            getSesion().delete(o);
            getTransc().commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            getSesion().close();
        }

    }

    @Override
    public Usuario findById(String o) {
        Usuario usuario = null;
        try {
            iniciaOperacion();
            usuario = (Usuario) getSesion().get(Usuario.class, o);
        } finally {
            getSesion().close();
        }
        return usuario;
    }

    public Usuario auntenticar(String id, String clave) {
        List<Usuario> usuarios = null;
        String hql = "from Usuario where id= '" + id + "' and clave='" + clave + "'";
        try {
            iniciaOperacion();
            usuarios = getSesion().createQuery(hql).list();
        } finally {
            getSesion().close();
        }
        if (usuarios != null && usuarios.size() > 0) {
            return usuarios.get(0);
        } else {
            return null;
        }
    }

    public String busquedaNombre(String id) {
        String hql = "select distinct f.nombre from Usuario u, Funcionario f where '" + id + "' =f.id";
        try {
            iniciaOperacion();
            String nombreFinal = (String) getSesion().createQuery(hql).uniqueResult();
            return nombreFinal;
        } finally {
            getSesion().close();
        }
    }

    public String busquedaRol(String id) {
        String hql = "select distinct r.descripcion from Usuario u, Funcionario f, Rol r where '"
                + id + "' =f.id and f.rol=r.id";
        try {
            iniciaOperacion();
            String nombreFinal = (String) getSesion().createQuery(hql).uniqueResult();
            return nombreFinal;
        } finally {
            getSesion().close();
        }
    }

    public String busquedaDependencia(String id) {
        String hql = "select distinct d.nombre from Usuario u, Funcionario f, "
                + "Dependencia d where " + id + " =f.id and f.dependencia=d.id";
        try {
            iniciaOperacion();
            String nombreFinal = (String) getSesion().createQuery(hql).uniqueResult();
            return nombreFinal;
        } finally {
            getSesion().close();
        }
    }

    @Override
    public List<Usuario> findAll() {
        List<Usuario> usuarios = null;
        String hql = "from Usuario";
        try {
            iniciaOperacion();
            usuarios = getSesion().createQuery(hql).list();
        } finally {
            getSesion().close();
        }
        return usuarios;
    }

    public List<Solicitud> getSolicitudes(String id) {
        List<Solicitud> solicitudesRaw = null;
        List<Solicitud> solicitudesFinal = new ArrayList<>();
        String sql = "select distinct s.id, s.comprobante,s.fecha,s.tipo,s.cantidad,s.total,e.descripcion\n"
                + "from Usuario u, Funcionario f, Dependencia d, Solicitud s, Estado e\n"
                + "where " + id + " =f.id and f.id=d.administrador and d.id=s.dependencia and s.estado=e.id;";
        try {
            iniciaOperacion();
            solicitudesRaw = (List<Solicitud>) getSesion().createSQLQuery(sql).list();
            Iterator itr = solicitudesRaw.iterator();
            while (itr.hasNext()) {
                Object[] obj = (Object[]) itr.next();
                Solicitud sol = new Solicitud();
                sol.setId(Integer.parseInt(String.valueOf(obj[0])));
                sol.setComprobante(String.valueOf(obj[1]));

                String fecha = String.valueOf(obj[2]);
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                System.out.println(fecha);
                
                Date date1 = format.parse(fecha);

                sol.setFecha(date1);

                sol.setTipo(String.valueOf(obj[3]));
                sol.setCantidad(Integer.parseInt(String.valueOf(obj[4])));
                sol.setTotal(Float.parseFloat(String.valueOf(obj[5])));
                Estado est = new Estado();
                est.setDescripcion(String.valueOf(obj[6]));
                sol.setEstado(est);
                solicitudesFinal.add(sol);
            }

        } catch (ParseException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            getSesion().close();
        }
        return solicitudesFinal;
    }

//    public List<Usuario> findByRol(String rol) {
//        List<Usuario> usuarios = null;
//        String hql = "from Usuario where rol= '" + rol + "'";
//        try {
//            iniciaOperacion();
//            usuarios = getSesion().createQuery(hql).list();
//        } finally {
//            getSesion().close();
//        }
//        return usuarios;
//    }
}
