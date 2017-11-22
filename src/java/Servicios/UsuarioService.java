/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Entidades.Usuario;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;

/**
 *
 * @author PC-Cristopher
 */
@WebService(serviceName = "UsuarioService")
public class UsuarioService {
    
    @PersistenceContext
    EntityManager em;

    /**
     * Created by Cristopher Salgado Input String nombre de Usuario Input String
     * contraseña Output Usuario object
     */
    @WebMethod(operationName = "AutenticarTrabajador")
    public Usuario AutenticarTrabajar(@WebParam(name = "correo") String correo, @WebParam(name = "contrasena") String contrasena) {
        try {
            Query q = em.createNativeQuery("SELECT * from TABLE( AUTENTICACION_PACKAGE.function_return_user(?,?))", Usuario.class);
            q.setParameter(1, correo);
            q.setParameter(2, contrasena);
            List<Usuario> usuarios = q.getResultList();
            for (Usuario a : usuarios) {
                if (correo.equals(a.getCorreo()) && contrasena.equals(a.getContrasena())) {
                    return a;
                }
            }
        } catch (Exception e) {
            System.err.println("Error ");
            System.err.println(e.getMessage());
            return new Usuario(BigDecimal.ZERO);
        }
        return new Usuario(BigDecimal.ZERO);
    }
    
    @WebMethod(operationName = "Autenticacion")
    public Object Autenticar(@WebParam(name = "correo") String correo, @WebParam(name = "contrasena") String contrasena) {
        try {
            Query q = em.createNativeQuery("SELECT * from TABLE( AUTENTICACION_PACKAGE.function_return_user(?,?))", Usuario.class);
            q.setParameter(1, correo);
            q.setParameter(2, contrasena);
            List<Usuario> usuarios = q.getResultList();
//            List<Usuario> usuarios = (List<Usuario>) em.createNativeQuery("select * from VIEW_USUARIOS c", Usuario.class)
//                    .getResultList();
            for (Usuario a : usuarios) {
                if (correo.equals(a.getCorreo()) && contrasena.equals(a.getContrasena())) {
                    return a;
                }
            }
        } catch (Exception e) {
            System.err.println("Error ");
            System.err.println(e.getMessage());
            return new Usuario(BigDecimal.ZERO);
        }
        return new Usuario(BigDecimal.ZERO);
    }

    /**
     * Created by Cristopher Salgado Output List<Usuario> List
     */
    @WebMethod(operationName = "Listado_usuarios")
    public List<Usuario> ListadoUsuarios() {
        List<Usuario> arr_cust = (List<Usuario>) em.createNativeQuery("select * from VIEW_USUARIOS c", Usuario.class)
                .getResultList();
        return arr_cust;
    }
    
    @WebMethod(operationName = "CREAR_USUARIO")
    public String CrearUsuario(
            @WebParam(name = "id") int id, @WebParam(name = "correo") String correo,
            @WebParam(name = "password") String password, @WebParam(name = "telefono") int telefono,
            @WebParam(name = "fecha_inicio") Date fecha_inicio, @WebParam(name = "fecha_actualizacion") Date fecha_actualizacion,
            @WebParam(name = "id_estado") int id_estado, @WebParam(name = "id_persona") int id_persona,
            @WebParam(name = "id_cargo") int id_cargo
    ) {
        try {
            StoredProcedureQuery query = em.createStoredProcedureQuery("CREAR_USUARIO");
            query.registerStoredProcedureParameter("ID_US", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("COR", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("PASS", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("TE", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("INI", Date.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("ACTU", Date.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("ID_ES", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("ID_PER", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("ID_CAR", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("SALIDA", Number.class, ParameterMode.OUT);
            query.setParameter("ID_US", id);
            query.setParameter("COR", correo);
            query.setParameter("PASS", password);
            query.setParameter("TE", telefono);
            query.setParameter("INI", fecha_inicio);
            query.setParameter("ACTU", fecha_actualizacion);
            query.setParameter("ID_ES", id_estado);
            query.setParameter("ID_PER", id_persona);
            query.setParameter("ID_CAR", id_cargo);
            query.execute();
            return query.getOutputParameterValue("SALIDA").toString();
        } catch (Exception e) {
            return 0 + "";
        }
    }
    
    @WebMethod(operationName = "Modificar_USUARIO")
    public String ModificarUsuario(
            @WebParam(name = "id") int id,
            @WebParam(name = "correo") String correo,
            @WebParam(name = "password") String password,
            @WebParam(name = "telefono") int telefono,
            @WebParam(name = "fecha_inicio") Date fecha_inicio,
            @WebParam(name = "fecha_actualizacion") Date fecha_actualizacion
    ) {
        try {
            StoredProcedureQuery query = em.createStoredProcedureQuery("ACTUALIZAR_USUARIO");
            query.registerStoredProcedureParameter("ID_US", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("COR", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("PASS", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("TE", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("INI", Date.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("ACTU", Date.class, ParameterMode.IN);
            
            query.registerStoredProcedureParameter("SALIDA", Number.class, ParameterMode.OUT);
            query.setParameter("ID_US", id);
            query.setParameter("COR", correo);
            query.setParameter("PASS", password);
            query.setParameter("TE", telefono);
            query.setParameter("INI", fecha_inicio);
            query.setParameter("ACTU", fecha_actualizacion);
            
            query.execute();
            em.getEntityManagerFactory().getCache().evictAll();
            return query.getOutputParameterValue("SALIDA").toString();
        } catch (Exception e) {
            System.out.println("Error en -> ModificarUsuario() -> " + e.getMessage());
            return 0 + "";
        }
    }
    
    @WebMethod(operationName = "Eliminar_usuario")
    public String EliminarUsuario(@WebParam(name = "id") int idd) {
        try {
            StoredProcedureQuery query = em.createStoredProcedureQuery("ELIMINAR_USUARIO");
            query.registerStoredProcedureParameter("ID_USU", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("SALIDA", Number.class, ParameterMode.OUT);
            query.setParameter("ID_USU", idd);
            query.execute();
            return query.getOutputParameterValue("SALIDA").toString();
        } catch (Exception e) {
            return 0 + "err";
        }
    }
}
